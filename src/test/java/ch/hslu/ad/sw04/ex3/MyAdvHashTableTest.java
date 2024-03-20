package ch.hslu.ad.sw04.ex3;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class MyAdvHashTableTest {

    private MyAdvHashTable<Integer> myTable;

    @BeforeEach
    public void init() {
        myTable = new MyAdvHashTable<Integer>();
    }

    @Test
    void addElement() {
        myTable.add(54);
        myTable.add(23);
        myTable.add(58);

        assertEquals(3, myTable.getSize());
    }

    @Test
    void addElementDuplicates() {
        myTable.add(3);
        myTable.add(4);

        assertFalse(myTable.add(3));
    }

    @Test
    void addElementAtIndexAlreadyTaken() {
        myTable.add(3);
        myTable.add(4);

        myTable.add(23);
    }

    @Test
    void addIsFull() {
        for (int i = 0; i < 10; i++) {
            myTable.add(i);
        }

        assertFalse(myTable.add(23));
    }

    @Test
    void remove() {
        for (int i = 0; i < 10; i++) {
            myTable.add(i);
        }

        myTable.remove(2);
        assertFalse(myTable.search(2));
    }

    @Test
    void removeElementNotThere() {
        myTable.add(54);
        myTable.add(4325);

        myTable.remove(21);
    }

    @Test
    void search() {
        myTable.add(54);
        myTable.add(4321);

        assertTrue(myTable.search(4321));
    }

    @Test
    void getSize() {
        myTable.add(44);
        myTable.add(4321);
        myTable.add(5543);

        assertEquals(3, myTable.getSize());
    }

    @Test
    void isFull() {
        for (int i = 0; i < 10; i++) {
            myTable.add(i);
        }

        assertFalse(myTable.add(4));
    }
}