package ch.hslu.ad.sw03;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class HashTreeTest {

    @BeforeEach
    void init() {
        HashTree<Integer> hashTree = new HashTree<>();

        hashTree.add(3);
        hashTree.add(12);
        hashTree.add(33);

    }

    @Test
    void add() {
    }

    @Test
    void testToString() {
    }
}