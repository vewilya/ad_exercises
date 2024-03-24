package ch.hslu.ad.sw02;

import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;

class ListTest {
    private static final Logger LOG = LoggerFactory.getLogger(ListTest.class);

    @Test
    void testListConstructor() {
        List<Integer> list = new List<Integer>();
        assertEquals(list.getSize(), 0);
    }

    @Test
    void add() {
        List<Integer> list = new List<Integer>();
        list.add(3);
        list.add(5);
        assertEquals(list.getSize(), 2);
    }

    @Test
    void add2() {
        List<Integer> list = new List<Integer>();
        list.add(2);
        list.add(4);

        assertEquals(list.getSize(), 2);
        LOG.info("List: {}", list);
        LOG.info("List Size: {}", list.getSize());
    }

    @Test
    void removeFirst() {
        List<Integer> list = new List<Integer>();
        list.add(44);
        list.add(4);
        list.add(8);

        list.remove(8);

        assertEquals(2, list.getSize());
        LOG.info("List: {}", list);
    }

    @Test
    void removeLast() {
        List<Integer> list = new List<Integer>();
        list.add(44);
        list.add(4);
        list.add(8);

        list.remove(44);

        assertEquals(list.getSize(), 2);
        LOG.info("List: {}", list);
    }

    @Test
    void removeMiddle() {
        List<Integer> list = new List<Integer>();
        list.add(44);
        list.add(4);
        list.add(8);

        list.remove(4);

        assertEquals(list.getSize(), 2);
        LOG.info("List: {}", list);
    }

    @Test
    void removeNotThere() {
        List<Integer> list = new List<Integer>();
        list.add(44);
        list.add(4);
        list.add(8);

        assertFalse(list.remove(14454));
        assertEquals(list.getSize(), 3);

        LOG.info("List: {}", list);
    }

    @Test
    void removeDoubleElements() {
        List<Integer> list = new List<Integer>();
        list.add(3);
        list.add(6);
        list.add(7);
        list.add(9);
        list.add(7);

        list.remove(7);
        LOG.info("List: {}", list);

        assertEquals(list.getSize(), 4);
    }


    @Test
    void getSize() {
        List<Integer> list = new List<Integer>();
        list.add(2);
        list.add(5);
        list.add(5);
        list.add(25);

        assertEquals(list.getSize(), 4);
    }

    @Test
    void contains() {
        List<Integer> list = new List<Integer>();
        list.add(2);
        list.add(5);
        list.add(5);
        list.add(25);

        assertEquals(list.contains(5), true);
        assertEquals(list.contains(3), false);
    }

    @Disabled
    void addList() {
        List<Integer> list = new List<Integer>();
        List<Integer> list2 = new List<Integer>();

        list.add(2);
        list.add(5);

        list2.add(56);
        list2.add(288);
        list.addList(list2);

        // assertEquals(list.getSize(), 8);
        System.out.println("size: " + list.getSize());
        System.out.println(list.toString());

        // System.out.println(list.toString());
    }

    @Test
    void testPop() {
        List<Integer> list = new List<Integer>();
        list.add(2);
        list.add(5);
        list.add(5);
        list.add(25);

        LOG.info("List: {}", list);
        list.pop();
        LOG.info("List after pop: {}", list);

        assertEquals(list.getSize(), 3);
    }

    @Test
    void testPrevious() {
        List<Integer> list = new List<Integer>();

        list.add(2);
        list.add(4);
        list.add(8);

        assertEquals(list.pop(), 8);

    }
}