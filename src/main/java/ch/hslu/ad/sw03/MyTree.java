package ch.hslu.ad.sw03;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class MyTree<T extends Comparable<T>> implements TreeInterface<T> {

    private Node<T> root;
    private static final Logger LOG = LoggerFactory.getLogger(MyTree.class);

    /**
     * Default Constructor
     */
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

        /*
         * Pass the element on to the recusrive function
         */
        this.root = addRecursive(this.root, element);

    }

    private Node<T> addRecursive(Node<T> current, T element) {
        /*
         * If the current node is null, we have found the place to insert the new node
         */
        if (current == null) {
            LOG.info("Adding new node with element {}", element);
            return new Node<>(element);
        }

        /*
         * If the element is smaller than the current node, we go left
         */
        if (element.compareTo(current.getElement()) < 0) {
            LOG.info("-> {} > {}", element, current.getElement());

            current.leftNode = addRecursive(current.leftNode, element);
            current.setLeftNode(current.leftNode);
        }

        /*
         * If the element is greater than the current node, we go right
         */
        if (element.compareTo(current.getElement()) > 0) {
            LOG.info("-> {} > {}", element, current.getElement());

            current.rightNode = addRecursive(current.rightNode, element);
            current.setRightNode(current.rightNode);
        }

        return current;
    }

    public Node<T> getRoot() {
        LOG.info("Returning root node {}", this.root);
        return this.root;
    }

    public T getElement(Node<T> node) {
        return node.getElement();
    }

    @Override
    public boolean contains(T element) {
        return containsRecursive(this.root, element);
    }

    private boolean containsRecursive(Node<T> current, T element) {
        if (current == null) {
            return false;
        }

        if (current.element == element)
            return true;
        else if (element.compareTo(current.element) < 0)
            return containsRecursive(current.leftNode, element);
        else
            return containsRecursive(current.rightNode, element);
    }

    @Override
    public int getDegree(T element) {
        // TODO Auto-generated method stub
        return 0;
    }

    @Override
    public int getHeight() {
        // TODO Auto-generated method stub
        return 0;
    }

    @Override
    public int getOrder() {
        // TODO Auto-generated method stub
        return 0;
    }

    @Override
    public List<T> getPath(T element) {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public int getWeight() {
        // TODO Auto-generated method stub
        return 0;
    }

    @Override
    public boolean remove(T element) {
        // TODO Auto-generated method stub
        return false;
    }

    @Override
    public String toString() {
        return "MyTree [root=" + root + "]";
    }

    private class Node<T> {

        private Node<T> leftNode;
        private Node<T> rightNode;
        private Node<T> parentNode;

        private T element;

        public Node(T element) {
            this.element = element;
            this.leftNode = null;
            this.rightNode = null;
            this.parentNode = null;
        }

        public Node<T> getParentNode(Node<T> node) {
            LOG.info("Returning parent node {}", node.parentNode);
            return node.parentNode;
        }

        public Node<T> getLeftNode(Node<T> node) {
            LOG.info("Returning left node {}", node.leftNode);
            return node.leftNode;
        }

        public Node<T> getRightNode(Node<T> node) {
            LOG.info("Returning right node {}", node.rightNode);
            return node.rightNode;
        }

        public void setLeftNode(Node<T> leftNode) {
            this.leftNode = leftNode;
        }

        public void setRightNode(Node<T> rightNode) {
            this.rightNode = rightNode;
        }

        public void setParentNode(Node<T> parentNode) {
            this.parentNode = parentNode;
        }

        public T getElement() {
            return this.element;
        }

        @Override
        public String toString() {
            return "Node [element: " + element + ", leftNode: " + leftNode + ", parentNode: " + parentNode
                    + ", rightNode: "
                    + rightNode + "]";
        }

    } /* Node */
}
