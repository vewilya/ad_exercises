package ch.hslu.ad.sw02;

import java.util.Arrays;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class Queue implements Queueble<Character> {
    private int capacity;
    private int readHead;
    private int writeHead;
    private char[] queue;

    private static final Logger LOG = LoggerFactory.getLogger(Queue.class);

    /**
     * Default constructor
     */
    public Queue() {
        this(100);
    }

    public Queue(int capacity) {
        this.capacity = capacity;
        this.queue = new char[capacity];
        this.readHead = 0;
        this.writeHead = -1;
    }

    @Override
    public boolean offer(Character element) {
        if (this.isFull()) {
            return false;
        }

        this.queue[++this.writeHead % this.capacity] = element;
        logHeads();
        return true;
    }

    @Override
    public Character poll() {
        if (this.isEmpty()) {
            throw new IllegalStateException("Queue is empty");
        }
        logHeads();
        return this.queue[this.readHead++ % this.capacity];
    }

    @Override
    public boolean isEmpty() {
        return this.writeHead < this.readHead;
    }

    @Override
    public boolean isFull() {
        return this.writeHead - this.readHead + 1 == this.capacity;
    }

    @Override
    public int getSize() {
        return (this.writeHead - this.readHead) + 1;
    }

    @Override
    public String toString() {
        return "Queue [Elements=" + Arrays.toString(queue) + ", capacity=" + capacity + ", readHead=" + readHead
                + ", writeHead=" + writeHead + ", size:" + this.getSize() + "]";
    }

    private void logHeads() {
        LOG.info("Read head: {}", +this.readHead);
        LOG.info("Write head: {}", +this.writeHead);
    }

    public static void main(String[] args) {
        Queue q = new Queue(4);
        // q.poll();
        q.offer('a');
        LOG.info("Polling: {}", q.poll());
        // q.offer('b');
        // q.offer('c');
        // LOG.info("Full? {}", q.isFull());
        // q.offer('d');

        // LOG.info("Queue: {}", q);
        // LOG.info("Full? {}", q.isFull());
    }

}
