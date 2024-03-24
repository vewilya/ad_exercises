package ch.hslu.ad.sw04.ex3;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Arrays;

public class HashTable<E> implements HashTableInterface<E> {

    private static final int MAX_TABLE_CAPACITY = 10;
    private static final Logger LOG = LoggerFactory.getLogger(HashTable.class);
    private final Object[] table;
    private int size;

    public HashTable() {
        this.table = new Object[MAX_TABLE_CAPACITY];
        this.size = 0;
    }


    @Override
    public boolean add(E element) {
        if (isFull()) {
            return false;
        } else {
            int index = getIndex(element);
            do {
                if (this.table[index] != null && !(this.table[index] instanceof Tombstone)) {
                    /* Duplicate -> return false */
                    if (this.table[index].equals(element)) {
                        LOG.info("Element already present at index -> {}", index);
                        return false;
                    } else {
                        /* increment */
                        index = (index + 1) % MAX_TABLE_CAPACITY;
                        LOG.info("Increment index -> {}", index);
                    }
                } else {
                    /* Found an empty spot for the element */
                    this.table[index] = element;
                    LOG.info("Added element {} at index {}.", element, index);
                    return true;
                }
            } while (index != getIndex(element));

            return true;
        }
    }

    @Override
    public boolean remove(E element) {
        int index = getIndex(element);

        if (this.table[index].equals(element)) {
            this.table[getIndex(element)] = new Tombstone();
            LOG.info("Removed element {} at index {} and set tombstone!", element, index);
            return true;
        } else {
            index = (index + 1) % MAX_TABLE_CAPACITY;
            LOG.info("Increment index -> {}", index);
            do {
                if (this.table[index] != null && this.table[index].equals(element)) {
                    this.table[getIndex(element)] = new Tombstone();
                    LOG.info("Removed element {} at index {} and set tombstone!", element, index);
                    return true;
                } else {
                    index = (index + 1) % MAX_TABLE_CAPACITY;
                    LOG.info("Increment index -> {}", index);
                }
            } while (index != getIndex(element)); /* Full circle check */
        }

        // Return false otherwise
        LOG.info("Element was not found!");
        return false;
    }

    @Override
    public boolean search(E element) {
        int index = getIndex(element);

        if (this.table[index] != null && this.table[index].equals(element)) {
            LOG.info("Found element at -> {}", index);
            return true;
        } else {
            index = (index + 1) % MAX_TABLE_CAPACITY;
            do {
                if (this.table[index] != null && this.table[index].equals(element)) {
                    LOG.info("Found element at -> {}", index);
                    return true;
                } else {
                    index = (index + 1) % MAX_TABLE_CAPACITY;
                    LOG.info("Increment index -> {}", index);
                }
            } while (index != getIndex(element)); /* Stop condition is one full pass through the table */

            LOG.info("We've come full circle. Element not found!");
        }

        return false;
    }

    @Override
    public int getIndexOfElement(E element) {
        int index = getIndex(element);
        if (this.table[index] != null && table[index].equals(element)) {
            LOG.info("Found index of element {} at -> {}", element, index);
            return index;
        } else {
            index = (index + 1) % MAX_TABLE_CAPACITY;
            LOG.info("Increment index -> {}", index);
            if (this.table[index] != null && table[index].equals(element)) {
                LOG.info("Found index of element {} at -> {}", element, index);
                return index;
            } else {
                do {
                    index = (index + 1) % MAX_TABLE_CAPACITY;
                    LOG.info("Increment index -> {}", index);
                } while (index != getIndex(element));
            }
        }

        LOG.info("Index for element {} was not found!", element);
        return -1;
    }

    private int getIndex(E element) {
        int index = Math.abs(element.hashCode() % MAX_TABLE_CAPACITY);
        LOG.info("Setting index {} for element {}", index, element);
        return index;
    }

    public final int getSize() {
        this.size = 0;

        for (Object element : table) {
            /* If element is not zero and is also not a Tombstone, we increment size. */
            if (element != null && !(element instanceof Tombstone)) this.size++;
        }
//        LOG.info("The table of size {} contains the following  number of elements: {}", MAX_TABLE_CAPACITY, this.size);
        return this.size;
    }

    @Override
    public boolean isFull() {
        return MAX_TABLE_CAPACITY - this.getSize() == 0;
    }

    @Override
    public String toString() {
        return "MyHashTable -> Capacity: " + HashTable.MAX_TABLE_CAPACITY + ", Actual Size: " + this.getSize() + ", \nTable Data: " + Arrays.toString(table);
    }


    //    public void setTombstone(int index) {
//        table[index] = new Tombstone();
//    }
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
