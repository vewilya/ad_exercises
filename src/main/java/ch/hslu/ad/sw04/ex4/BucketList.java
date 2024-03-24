package ch.hslu.ad.sw04.ex4;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Iterator;
import java.util.NoSuchElementException;

public class BucketList<T> implements Iterable<T> {

    private static final Logger LOG = LoggerFactory.getLogger(BucketList.class);
    private Node<T> head;
    private int size;

    public BucketList() {
        this.head = null;
    }

    public static void main(String[] args) {
        BucketList<Integer> li = new BucketList<>();
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


    @Override
    public Iterator<T> iterator() {
        return new ListIterator(head);
    }

    public void add(T element) {
        Node<T> newNode = new Node<>(element);

        if (this.head == null) {
            this.head = newNode;

            LOG.info("Bucket: adding {}", newNode.getElement());
            LOG.info("{} -> {}", newNode.getElement(), newNode.getNext());
            this.size = 1;
        } else {
            Node<T> current = head;
            this.head = newNode;

            newNode.setNext(current);
            current.setPrevious(newNode);

            LOG.info("Bucket: adding {}", newNode.getElement());
            LOG.info("{} -> {}", current.getElement(), newNode.getElement());
            this.size++;
        }

    }

    public void addList(BucketList<T> list) {
        if (list.size == 0) {
            LOG.info("Bucket is empty");
        } else {
            LOG.info("Adding bucket {} to bucket {}", list, this);
            for (T t : list)
                this.add(t);
        }
    }

    public T pop() {
        if (head == null) {
            LOG.info("Bucket is empty");
            return null;
        } else {
            Node<T> current = head;
            head = head.getNext();
            LOG.info("Popping element: {}", current.element);
            this.size--;

            return current.getElement();
        }
    }

    public boolean remove(T elementToRemove) {
        Node<T> current = this.head;

        if (current.getElement().equals(elementToRemove)) {
            this.head = current.getNext();
            LOG.info("Element {} was removed from the list", current);
            this.size--;

            return true;
        } else {
            while (current.hasNext()) {
                current = current.getNext();

                if (current.getElement().equals(elementToRemove)) {
                    current.getPrevious().setNext(current.getNext());
                    LOG.info("Element {} was removed from the list", current);
                    this.size--;
                    return true;
                }
            }
        }

        LOG.info("Element {} was not found in the list", elementToRemove);
        return false;
    }

    public boolean contains(T elementToCheck) {

        if (this.head == null) {
            return false;
        } else {
            Node<T> current = this.head;
            
            if (current.getElement() != null && current.getElement().equals(elementToCheck))
                return true;
            else {
                while (current != null) {
                    if (current.getElement() != null && current.getElement().equals(elementToCheck))
                        return true;

                    current = current.getNext();
                }

                return false;
            }
        }
    }


    public int getSize() {
        return this.size;
    }

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

    ;

    private static final class Node<T> {

        private final T element;
        private Node<T> next;
        private Node<T> previous;

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

        public void setNext(Node<T> newNext) {
            this.next = newNext;
        }

        public Node<T> getPrevious() {
            return previous;
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

}
