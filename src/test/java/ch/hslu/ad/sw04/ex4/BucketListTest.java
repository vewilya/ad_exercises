package ch.hslu.ad.sw04.ex4;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

class BucketListTest {

    @Test
    void contains() {
        BucketList<Integer> li = new BucketList<>();
        li.add(4);
        li.add(8);
        li.add(91);
        li.add(9);

        assertTrue(li.contains(4));
    }

    @Test
    void containsNot() {
        BucketList<Integer> li = new BucketList<>();
        li.add(4);
        li.add(9);

        assertFalse(li.contains(3));
    }
}