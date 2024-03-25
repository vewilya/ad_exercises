package ch.hslu.ad.sw04.ex4;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Arrays;

public class BucketHashTable<E> implements BucketHashTableInterface<E> {

    private static final int MAX_TABLE_CAPACITY = 10;
    private static final Logger LOG = LoggerFactory.getLogger(BucketHashTable.class);
    private final BucketList<E>[] bucketHashTable;
    private int size;

    @SuppressWarnings("unchecked")
    public BucketHashTable() {
        this.bucketHashTable = new BucketList[MAX_TABLE_CAPACITY];

        for (int i = 0; i < MAX_TABLE_CAPACITY; i++) {
            this.bucketHashTable[i] = new BucketList<E>();
        }

        this.size = 0;
    }

    public static void main(String[] args) {
        BucketHashTable<Integer> bht = new BucketHashTable<>();

        LOG.info("Size: {}", bht.getSize());
        LOG.info("table View: {}", bht);

        bht.add(5);
        bht.add(57);
        bht.add(77);

        LOG.info("Added Element Table View: {}", bht);
    }

    @Override
    public boolean add(E element) {

        if (isFull()) {
            return false;
        } else {
            int index = getIndex(element);

            if (this.bucketHashTable[index] == null)
                return false;

            if (this.bucketHashTable[index].contains(element)) {
                LOG.info("Duplicates!");
                return false;
            } else {
                this.bucketHashTable[index].add(element);
                return true;
            }
        }
    }

    @Override
    public boolean remove(E elementToRemove) {
        int index = getIndex(elementToRemove);

        if (this.search(elementToRemove)) {
            this.bucketHashTable[index].remove(elementToRemove);
            return true;
        } else {
            LOG.info("Element was not found!");
            return false;
        }
    }

    @Override
    public boolean search(E element) {
        int index = getIndex(element);

        return this.bucketHashTable[index].contains(element);
    }


    private int getIndex(E element) {
        return Math.abs(element.hashCode() % MAX_TABLE_CAPACITY);
    }

    public final int getSize() {
        this.size = 0;

        for (int i = 0; i < MAX_TABLE_CAPACITY; i++) {
            if (bucketHashTable[i].getSize() != 0) this.size++;
        }

        return this.size;
    }

    @Override
    public boolean isFull() {
        return MAX_TABLE_CAPACITY - this.getSize() == 0;
    }

    @Override
    public String toString() {
        return "BucketHashTable -> Capacity: " + BucketHashTable.MAX_TABLE_CAPACITY + ", Actual Size: " + this.getSize() + ", \nTable Data: " + Arrays.toString(bucketHashTable);
    }
}
