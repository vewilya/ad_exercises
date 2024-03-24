package ch.hslu.ad.sw04.ex4;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import static org.junit.jupiter.api.Assertions.*;

class BucketHashTableTest {
    private static final Logger LOG = LoggerFactory.getLogger(BucketHashTableTest.class);
    private BucketHashTable<Integer> myTable;

    @BeforeEach
    public void init() {
        myTable = new BucketHashTable<>();
    }

    @Test
    void add() {
        myTable.add(4);
        myTable.add(66);

        LOG.info("Table View: {}", myTable);
        assertTrue(myTable.search(4));
    }

    @Test
    void searchElementThere() {
        myTable.add(44);
        myTable.add(66);

        LOG.info("Table View: {}", myTable);
        assertTrue(myTable.search(44));
    }

    @Test
    void searchElementThereLaterInTheList() {
        myTable.add(44);
        myTable.add(66);
        myTable.add(19);
        myTable.add(15696);

        LOG.info("Table View: {}", myTable);
        assertTrue(myTable.search(15696));
    }

    @Test
    void searchElementThereLaterInTheList2() {
        myTable.add(44);
        myTable.add(66);
        myTable.add(19);
        myTable.add(15696);
        myTable.add(4556);
        myTable.add(2556);

        LOG.info("Table View: {}", myTable);
        assertTrue(myTable.search(15696));
    }

    @Test
    void searchElementNotThere() {
        myTable.add(47);
        myTable.add(66);

        LOG.info("Table View: {}", myTable);
        assertFalse(myTable.search(4));
    }


    @Test
    void remove() {
        myTable.add(6);
        myTable.add(9);

        myTable.add(64);
        myTable.add(68);
        LOG.info("Table: {}", myTable);
        assertTrue(myTable.search(9));

        myTable.remove(9);
        LOG.info("Table: {}", myTable);
        assertFalse(myTable.search(9));
    }

    @Test
    void removeElementEndOfBucketList() {
        myTable.add(44);
        myTable.add(66);
        myTable.add(19);
        myTable.add(15696);
        myTable.add(4556);
        myTable.add(2556);

        myTable.remove(15696);
        assertFalse(myTable.search(15696));
    }

    @Test
    void search() {
        for (int i = 33; i < 43; i++) {
            myTable.add(i);
        }

        assertTrue(myTable.search(42));
    }

    @Test
    void getSize() {
        int size = 6;

        for (int i = 0; i < size; i++) {
            myTable.add(i);
        }

        assertEquals(size, myTable.getSize());
    }

    @Test
    void isFull() {
        for (int i = 0; i < 10; i++) {
            myTable.add(i);
        }

        assertTrue(myTable.isFull());
        assertFalse(myTable.add(64));
    }
}