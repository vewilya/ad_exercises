package ch.hslu.ad.sw02;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

public class QueueTest {

    @Test
    void testConstructor() {
        Queue queue = new Queue();
        assertEquals(true, queue.isEmpty());
    }

    @Test
    void testGetSize() {
        Queue queue = new Queue();
        assertEquals(0, queue.getSize());

        queue.offer('a');
        queue.offer('b');

        assertEquals(2, queue.getSize());
    }

    @Test
    void testIsEmpty() {
        Queue queue = new Queue();
        assertEquals(true, queue.isEmpty());

        queue.offer('a');
        assertEquals(false, queue.isEmpty());
    }

    @Test
    void testIsFull() {
        Queue queue = new Queue(2);
        System.out.println(queue.toString());

        queue.offer('a');
        queue.offer('b');

        assertEquals(true, queue.isFull());
    }

    @Test
    void testOffer() {
        Queue queue = new Queue();
        queue.offer('a');
        assertEquals(false, queue.isEmpty());
    }

    @Test
    void testPoll() {
        Queue q = new Queue(4);
        q.offer('a');
        q.offer('b');
        q.offer('c');

        assertEquals('a', q.poll());
    }

}
