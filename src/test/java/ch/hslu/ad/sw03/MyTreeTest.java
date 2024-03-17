package ch.hslu.ad.sw03;

import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;

public class MyTreeTest {
    @Test
    void testConstructor() {
        MyTree<Integer> tree = new MyTree<>();
        assertTrue(tree.getRoot() == null);

        tree.add(2);
        assertTrue(tree.getRoot() != null);
    }

    @Test
    void testAdd() {
        MyTree<Integer> tree = new MyTree<>();
        tree.add(2);
        assertTrue(tree.contains(2));
    }

    @Test
    void testContains() {
        MyTree<Integer> tree = new MyTree<>();
        tree.add(-12);
        assertTrue(tree.contains(-12));
    }
}
