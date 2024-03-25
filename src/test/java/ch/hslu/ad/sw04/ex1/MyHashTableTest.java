package ch.hslu.ad.sw04.ex1;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import static org.junit.jupiter.api.Assertions.*;

class MyHashTableTest {
    private static final Logger LOG = LoggerFactory.getLogger(MyHashTableTest.class);
    private MyHashTable<Integer> myTable;

    @BeforeEach
    public void init() {
        LOG.info("startup");
        myTable = new MyHashTable<Integer>();
    }

    @Test
    void add() {
        myTable.add(80);
        LOG.info("Table -> {}", myTable);

        assertTrue(myTable.search(80));
    }

    @Test
    void addMultiple() {
        for (int i = 0; i < 7; i++) {
            myTable.add(i);
        }

        LOG.info("Table -> {}", myTable);

        assertEquals(7, myTable.getSize());
    }

    @Test
    void addCollision() {
        myTable.add(80);
        myTable.add(64);
        myTable.add(79);

        myTable.add(40);
        LOG.info("Table -> {}", myTable);

        assertFalse(myTable.search(80));
    }

    @Test
    void remove() {
        myTable.add(80);
        myTable.add(42);
        LOG.info("Table -> {}", myTable);
        myTable.remove(80);
        LOG.info("Table -> {}", myTable);

        assertFalse(myTable.search(80));
        assertTrue(myTable.search(42));
    }

    @Test
    void search() {
        myTable.add(80);
        myTable.add(64);
        myTable.add(79);

        assertTrue(myTable.search(64));
    }

    @Test
    void getSize() {
        for (int i = 0; i < 7; i++) {
            myTable.add(i);
        }

        assertEquals(7, myTable.getSize());
    }
}