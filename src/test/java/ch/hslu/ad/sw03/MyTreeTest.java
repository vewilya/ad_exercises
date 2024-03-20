package ch.hslu.ad.sw03;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class MyTreeTest {
    @BeforeAll
    static void init() {
        MyTree<Integer> tree = new MyTree<>();
        tree.add(23);
        tree.add(2);
        tree.add(25);
        tree.add(12);
    }


    @Test
    void testConstructor() {
        MyTree<Integer> tree = new MyTree<>();
        assertNull(tree.getRoot());

        tree.add(2);
        assertNotNull(tree.getRoot());
    }

    @Test
    void testAdd() {
        MyTree<Integer> tree = new MyTree<>();
        tree.add(2);
        assertTrue(tree.search(2));
    }

    @Test
    void testContains() {
        MyTree<Integer> tree = new MyTree<>();
        tree.add(-12);
        assertTrue(tree.search(-12));
    }

    @Disabled
    void testGetHeight() {
        MyTree<Integer> tree = new MyTree<>();
        tree.add(20);
        tree.add(1);
        tree.add(4);
        tree.add(25);
        tree.add(30);

        assertEquals(3, tree.getHeight());
    }

    @Test
    void testGetDepth() {
        MyTree<Integer> tree = new MyTree<>();

        tree.add(2);
        tree.add(8);
        tree.add(9);
        tree.add(10);
        tree.add(13);
        tree.add(11);
        tree.add(7);
        tree.add(4);
        tree.add(15);
        tree.add(1);

        assertEquals(5, tree.getDepth(15));
    }

    @Test
    void getWeight() {
        MyTree<Integer> tree = new MyTree<>();

        tree.add(2);
        tree.add(8);
        tree.add(9);
        tree.add(10);
        tree.add(13);
        tree.add(11);
        tree.add(7);
        tree.add(4);
        tree.add(15);
        tree.add(1);

        assertEquals(10, tree.getWeight());
    }

    @Test
    void testGetPath() {
        MyTree<Integer> tree = new MyTree<>();

        tree.add(2);
        tree.add(8);
        tree.add(9);
        tree.add(10);
        tree.add(13);
        tree.add(11);
        tree.add(7);
        tree.add(4);
        tree.add(15);
        tree.add(1);

        assertEquals(2, tree.getPath(13).get(0));
        assertEquals(8, tree.getPath(13).get(1));
        assertEquals(9, tree.getPath(13).get(2));
        assertEquals(10, tree.getPath(13).get(3));

    }

}
