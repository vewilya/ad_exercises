package ch.hslu.ad.sw04.ex3;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import static org.junit.jupiter.api.Assertions.*;

class HashTableTest {
    private static final Logger LOG = LoggerFactory.getLogger(HashTableTest.class);
    private HashTable<Integer> myTable;

    @BeforeEach
    public void init() {
        myTable = new HashTable<Integer>();
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

        assertTrue(myTable.add(23));
        assertEquals(3, myTable.getSize());
        LOG.info("Table {}", myTable);
    }

    @Test
    void addNegativeValue() {
        myTable.add(3);
        myTable.add(4);
        assertTrue(myTable.add(-6));
    }

    @Test
    void addElementTableFull() {
        for (int i = 0; i < 10; i++) {
            myTable.add(i);
        }

        assertFalse(myTable.add(4));
    }


    @Test
    void removeElementThere() {
        myTable.add(3);
        myTable.add(4);
        myTable.add(431);
        myTable.add(98);

        assertTrue(myTable.remove(431));
        LOG.info("table view: {}", myTable);
    }

    @Test
    void removeElementNotThere() {
        myTable.add(32);
        myTable.add(45);
        myTable.add(436);
        myTable.add(981);

        assertFalse(myTable.remove(21));
        LOG.info("table view: {}", myTable);
    }

    @Test
    void addElementTombstoneCase() {
        myTable.add(3);
        myTable.add(4);
        myTable.add(56);
        myTable.remove(4);
        LOG.info("Table: {}", myTable);

        myTable.add(23);
        LOG.info("Table: {}", myTable);

        assertEquals(3, myTable.getSize());
    }

    @Test
    void removeElementTableFull() {
        for (int i = 0; i < 10; i++) {
            myTable.add(i);
        }

        assertTrue(myTable.remove(4));
        assertFalse(myTable.isFull());
    }

    @Test
    void testSearchElement() {
        myTable.add(3);
        myTable.add(4);

        assertTrue(myTable.search(4));
    }

    @Test
    void testSearchElementNotThere() {
        myTable.add(3);
        myTable.add(4);
        myTable.add(431);
        myTable.add(98);

        assertFalse(myTable.search(9));
    }

    @Test
    void addIsFull() {
        for (int i = 0; i < 10; i++) {
            myTable.add(i);
        }

        assertFalse(myTable.add(23));
    }


    @Test
    void getSize() {
        myTable.add(44);
        myTable.add(4321);
        myTable.add(5543);

        assertEquals(3, myTable.getSize());
    }


}