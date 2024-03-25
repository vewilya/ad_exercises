package ch.hslu.ad.sw04.ex1;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Arrays;

public class MyHashTable<E> implements HashTableInterface<E> {

    private static final int TABLE_SIZE = 10;
    private static final Logger LOG = LoggerFactory.getLogger(MyHashTable.class);
    private final Object[] table;
    private int size;

    public MyHashTable() {
        this.table = new Object[TABLE_SIZE];
        this.size = 0;
    }

    @Override
    public void add(E element) {
        this.table[getIndex(element)] = element;
        this.size++;
        LOG.info("Added element {} at index {}", element, getIndex(element));
    }

    @Override
    public boolean remove(E element) {
        if (search(element)) {
            this.table[getIndex(element)] = null;
            this.size--;
            LOG.info("Removed element {} at index {}", element, getIndex(element));
            return true;
        }

        return false;
    }

    @Override
    public boolean search(E element) {
        return table[getIndex(element)] != null && table[getIndex(element)].equals(element);
    }

    private int getIndex(E element) {
        return Math.abs(element.hashCode() % TABLE_SIZE);
    }

    public final int getSize() {
        return this.size;
    }

    @Override
    public String toString() {
        return "MyHashTable -> Capacity: " + MyHashTable.TABLE_SIZE + ", Actual Size: " + this.getSize() + ", \nTable Data: " + Arrays.toString(table);
    }
}
