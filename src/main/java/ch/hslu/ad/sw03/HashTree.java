package ch.hslu.ad.sw03;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.ArrayList;
import java.util.List;

public class HashTree<T extends Comparable<T>> implements TreeInterface<T> {

    private HashNode root;
    private static final Logger LOG = LoggerFactory.getLogger(HashTree.class);
    private int weightCounter = 0;
    static final int BINARY_TREE_ORDER = 2;

    /**
     * Default Constructor
     */
    public HashTree() {
        this.root = null;
    }

    @Override
    public void add(T element) {
        if (element == null) {
            throw new NullPointerException("Given element is null!");
        }

        this.root = addRecursive(this.root, element);
    }

    private HashNode addRecursive(HashNode current, T element) {
        /*
         * If the current node is null, we have found the place to insert the new node
         */
        if (current == null) {
            LOG.info("Adding new node with element {}", element);
            return new HashNode(element);
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

        HashNode current = this.root;

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
        LOG.info("Returning root node {}", this.root);
        return this.root.element;
    }


    @Override
    public boolean search(T element) {
        return searchRecursive(this.root, element);
    }

    private boolean searchRecursive(HashNode current, T element) {

        if (current == null) {
            return false;
        }

        if (current.element == element) {
            return true;
        } else if (element.compareTo(current.element) < 0) {
            LOG.info("-> {} < {}", element, current.element);
            return searchRecursive(current.leftNode, element);
        } else {
            LOG.info("-> {} < {}", element, current.element);
            return searchRecursive(current.rightNode, element);
        }
    }

    public int traverseInOrder(HashNode node) {

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

        HashNode current = this.root;
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
        HashNode current = this.root;

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

        HashNode current = this.root;
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
        return "MyTree [root=" + this.root + "]";
    }

    private class HashNode {

        private HashNode leftNode;
        private HashNode rightNode;
        private final T element;
        private int hashCode;

        public HashNode(T element) {

            this.leftNode = null;
            this.rightNode = null;
            this.element = element;

            this.hashCode = element.hashCode();
            LOG.info("Hash: {}", this.hashCode);
        }

        public int getHashCode() {
            return this.hashCode;
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

    } /* Node */

    public static void main(String[] args) {
        HashTree<Integer> tree = new HashTree<>();
        tree.add(3);
        tree.add(4);
        tree.add(2);
        tree.add(1);
    }
}
