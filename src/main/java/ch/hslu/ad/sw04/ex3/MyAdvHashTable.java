package ch.hslu.ad.sw04.ex3;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Arrays;

public class MyAdvHashTable<E> implements AdvHashTableInterface<E> {

    private static final int MAX_TABLE_CAPACITY = 10;
    private static final Logger LOG = LoggerFactory.getLogger(MyAdvHashTable.class);
    private final Object[] table;
    private int size;

    public MyAdvHashTable() {
        this.table = new Object[MAX_TABLE_CAPACITY];
        this.size = 0;
    }

    public static void main(String[] args) {

        MyAdvHashTable<Integer> table = new MyAdvHashTable<>();
        table.add(3);
        table.add(7);
        table.setTombstone(6);
        table.setTombstone(9);

        LOG.info("Table View: {}", table);
    }

    private void setTombstone(int index) {
        table[index] = new Tombstone();
    }

    @Override
    public boolean add(E element) {
        if (this.isFull()) {
            return false;
        } else {
            int index = getIndex(element);

            if (!search(element)) {

//                do {
//
//                } while ()

                if ((this.table[index] instanceof Tombstone) || this.table[index] == null)
                    this.table[index] = element;
                else {
                    index = (index + 1) % MAX_TABLE_CAPACITY;
                }

                LOG.info("Added element {} at index {}", element, getIndex(element));
            } else {
                LOG.info("Element is already in the table.");
                return false;
            }

            return true;
        }

    }

    @Override
    public boolean remove(E element) {
        // Look for element in the table and remove if existent.
        if (search(element)) {
            this.table[getIndex(element)] = null;
            LOG.info("Removed element {} at index {}", element, getIndex(element));
            return true;
        }

        // Return false otherwise
        LOG.info("Element was not found!");
        return false;
    }

    @Override
    public boolean search(E element) {
        return table[getIndex(element)] != null && table[getIndex(element)].equals(element);
    }

    private int getIndex(E element) {
        return element.hashCode() % MAX_TABLE_CAPACITY;
    }

    public final int getSize() {
        this.size = 0;

        for (Object element : table) {
            if (element != null && !(element instanceof Tombstone)) this.size++;
        }

        return this.size;
    }

    public boolean isFull() {
        return MAX_TABLE_CAPACITY - this.getSize() == 0;
    }

    @Override
    public String toString() {
        return "MyHashTable -> Capacity: " + MyAdvHashTable.MAX_TABLE_CAPACITY + ", Actual Size: " + this.getSize() + ", \nTable Data: " + Arrays.toString(table);
    }

    private static final class Tombstone {
        public Tombstone() {
            // Not implemented
        }

        @Override
        public String toString() {
            return "🪦";
        }
    }
}
