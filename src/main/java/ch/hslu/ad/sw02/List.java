package ch.hslu.ad.sw02;

import java.util.Iterator;
import java.util.NoSuchElementException;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class List<T> implements Iterable<T> {

    private Node<T> head;
    private int size;
    private static final Logger LOG = LoggerFactory.getLogger(List.class);

    public List() {
        this.head = null;
    }

    @Override
    public Iterator<T> iterator() {
        return new ListIterator(head);
    }

    private static final class Node<T> {

        private Node<T> next;
        private Node<T> previous;
        private final T element;

        public Node(T element) {
            this.element = element;
            this.next = null;
            this.previous = null;
        }

        public T getElement() {
            return element;
        }

        public Node<T> getNext() {
            return next;
        }

        public Node<T> getPrevious() {
            return previous;
        }

        public void setNext(Node<T> newNext) {
            this.next = newNext;
        }

        public void setPrevious(Node<T> newPrevious) {
            this.previous = newPrevious;
        }

        public boolean hasNext() {
            return this.next != null;
        }

        @Override
        public String toString() {
            return "Node [" + element + "]";
        }

    }

    private class ListIterator implements Iterator<T> {

        private final Node<T> next;

        public ListIterator(Node<T> head) {
            this.next = head;
        }

        @Override
        public boolean hasNext() {
            return this.next != null;
        }

        @Override
        public T next() {
            if (this.hasNext()) {
                return next.getElement();
            } else {
                throw new NoSuchElementException();
            }
        }

    }

    public void add(T element) {
        Node<T> newNode = new Node<>(element);

        if (this.head == null) {
            this.head = newNode;

            LOG.info("Adding Node: {}", newNode.getElement());
            LOG.info("New Node {}, last node {}", newNode.getElement(), newNode.getNext());
            this.size = 1;
        } else {
            Node<T> current = head;
            this.head = newNode;

            newNode.setNext(current);
            current.setPrevious(newNode);

            LOG.info("Adding Node: {}", newNode.getElement());
            LOG.info("Older Node: {} with new Node {}", current.getElement(), newNode.getElement());
            this.size++;
        }

    }

    public void addList(List<T> list) {
        if (list.size == 0) {
            LOG.info("List is empty");
        } else {
            LOG.info("Adding list {} to list {}", list, this);
            for (T t : list)
                this.add(t);
        }
    }

    public T pop() {
        if (head == null) {
            LOG.info("List is empty");
            return null;
        } else {
            Node<T> current = head;
            head = head.getNext();
            LOG.info("Popping element: {}", current.element);
            this.size--;

            return current.getElement();
        }
    }

    public void remove(T elementToRemove) {
        Iterator<T> iterator = new ListIterator(head);

        while (iterator.hasNext()) {
            T t = iterator.next();
            if (t == elementToRemove) {
                //
                LOG.info("Element {} was removed from the list!", elementToRemove);
                return;
            }
        }

        LOG.info("Element {} was not found in the list!", elementToRemove);
    }

    public boolean contains(T element) {

        for (T t : this) {
            if (t.equals(element)) {
                LOG.info("Element {} is in the list", element);
                return true;
            }
        }

        LOG.info("Element {} is not in the list", element);

        return false;
    }

    public int getSize() {
        return this.size;
    };

    @Override
    public String toString() {

        if (head == null) {
            return "List is empty";
        } else {
            Node<T> current = head;

            StringBuilder stringList = new StringBuilder();

            stringList.append(current.toString());

            while (current.hasNext()) {
                stringList.append(" --> " + current.getNext());
                current = current.getNext();
            }

            return stringList.toString();
        }
    }

    public static void main(String[] args) {
        List<Integer> li = new List<>();
        li.add(22);
        li.add(12);
        li.add(432);
        li.add(741);

        LOG.info("Size: {} ", li.getSize());

        int sum = 0;

        while (li.iterator().hasNext()) {

            int element = li.pop();
            sum += element;
        }

        LOG.info("Sum: {} ", sum);
        LOG.info("Size: {} ", li.getSize());

    }

}
