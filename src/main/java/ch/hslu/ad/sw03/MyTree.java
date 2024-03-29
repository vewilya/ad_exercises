package ch.hslu.ad.sw03;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.ArrayList;
import java.util.List;

public class MyTree<T extends Comparable<T>> implements TreeInterface<T> {

    private Node root;
    private static final Logger LOG = LoggerFactory.getLogger(MyTree.class);

    private int weightCounter = 0;

    static final int BINARY_TREE_ORDER = 2;

    public MyTree() {
        this.root = null;
    }

    @Override
    public void add(T element) {
        /*
         * NullCheck
         */
        if (element == null) {
            throw new NullPointerException("Given element is null!");
        }

        if (this.search(element)) {
            throw new IllegalArgumentException("Element already exists in the tree!");
        }

        /*
         * Pass the element on to the recusrive function
         */
        this.root = addRecursive(this.root, element);
    }

    private Node addRecursive(Node current, T element) {
        /*
         * If the current node is null, we have found the place to insert the new node
         */
        if (current == null) {
            LOG.info("Adding new node with element {}", element);
            return new Node(element);
        }

        /*
         * If the element is smaller than the current node, we go left
         */
        if (element.compareTo(current.getElement()) < 0) {
            LOG.info("-> {} > {}", element, current.getElement());
            current.leftNode = addRecursive(current.leftNode, element);
        } else if (element.compareTo(current.getElement()) > 0) {
            LOG.info("-> {} > {}", element, current.getElement());
            current.rightNode = addRecursive(current.rightNode, element);
        }

        return current;
    }

    @Override
    public boolean remove(T element) {
        if (element == null) {
            throw new NullPointerException("Given element is null!");
        }

        Node current = this.root;

        while (current.getElement() != element) {
            if (element.compareTo(current.getElement()) < 0) {
                current = current.leftNode;
            } else {
                current = current.rightNode;
            }
        }

        current = null;

        return true;
    }

    public T getRoot() {
        if (this.root == null) {
            return null;
        }

        LOG.info("Returning root node {}", this.root);
        return this.root.element;
    }

    @Override
    public boolean search(T element) {
        return searchRecursive(this.root, element);
    }

    private boolean searchRecursive(Node current, T element) {

        if (current == null) {
            return false;
        }

        if (current.element.equals(element)) {
            return true;
        } else if (element.compareTo(current.element) < 0) {
            LOG.info("-> {} < {}", element, current.element);
            return searchRecursive(current.leftNode, element);
        } else {
            LOG.info("-> {} < {}", element, current.element);
            return searchRecursive(current.rightNode, element);
        }
    }

    private int traverseInOrder(Node node) {

        if (node != null) {
            weightCounter++;
            traverseInOrder(node.leftNode);
            LOG.info("{}", node.element);
            traverseInOrder(node.rightNode);
        }

        return weightCounter;
    }

    @Override
    public int getDegree(T element) {
        if (element == null) {
            throw new NullPointerException("Given element is null!");
        }

        Node current = this.root;
        int degree = 0;

        /*
         * Let's find the node
         */
        while (current.getElement() != element) {
            if (element.compareTo(current.getElement()) < 0) {
                current = current.leftNode;
            } else {
                current = current.rightNode;
            }
        }

        /*
         * Let's see how many child nodes we have
         */
        if (current.leftNode != null) {
            degree++;
        }

        if (current.rightNode != null) {
            degree++;
        }

        LOG.info("Returning degree {}", degree);
        return degree;
    }

    @Override
    public int getDepth(T element) {
        if (element == null) {
            throw new NullPointerException("Given element is null!");
        }

        LOG.info("Returning depth {}", getPath(element).size() - 1);
        return getPath(element).size() - 1;
    }

    @Override
    public int getHeight() {
        int height = 0;
        Node current = this.root;

        while (current != null) {
            height++;
            current = current.leftNode;
        }

        return height;
    }

    @Override
    public int getOrder() {
        return BINARY_TREE_ORDER;
    }

    @Override
    public List<T> getPath(T element) {

        if (null == element) {
            throw new NullPointerException("Given element is null! No dodo!");
        }

        Node current = this.root;
        ArrayList<T> path = new ArrayList<>();

        // Adding the root element to the path
        path.add(current.getElement());

        while (current.getElement() != element) {
            if (element.compareTo(current.getElement()) < 0) {
                current = current.leftNode;
            } else {
                current = current.rightNode;
            }

            path.add(current.getElement());
        }

        LOG.info("Path: {}", path);

        return path;
    }

    @Override
    public int getWeight() {
        int weight = this.traverseInOrder(this.root);
        LOG.info("Returning weight {}", weightCounter);
        return weight;
    }

    @Override
    public String toString() {
        return "MyTree [root=" + root + "]";
    }

    private class Node {

        private Node leftNode;
        private Node rightNode;

        private T element;

        public Node(T element) {
            this.element = element;
            this.leftNode = null;
            this.rightNode = null;
        }

        public boolean isLeaf() {
            return this.leftNode == null && this.rightNode == null;
        }

        public T getElement() {
            return this.element;
        }

        @Override
        public String toString() {
            return "Node: " + this.element + " LeftNode: " + this.leftNode + " RightNode: " + this.rightNode;
        }

    }
}
