package ch.hslu.ad.sw01.MemoryDemo;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.Objects;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class Allocation implements Comparable<Allocation> {
    private final int adress;
    private final int size; // number of bytes

    private static final Logger LOG = LoggerFactory.getLogger(Allocation.class);

    public Allocation(final int adress, final int size) {
        this.adress = adress;
        this.size = size;
    }

    public int getAdress() {
        return adress;
    }

    public int getSize() {
        return size;
    }

    public static final Comparator<Allocation> ADRESS_COMPARATOR = (a1, a2) -> Integer.compare(a1.getAdress(),
            a2.getAdress());

    @Override
    public final boolean equals(final Object object) {
        if (object == this) {
            return true;
        }
        return (object instanceof Allocation allocation)
                && (this.adress == allocation.adress)
                && (this.size == allocation.size);
    }

    @Override
    public final int hashCode() {
        return Objects.hash(this.adress, this.size);
    }

    @Override
    public int compareTo(Allocation o) {
        return Integer.compare(this.adress, o.adress);
    }

    @Override
    public String toString() {
        return String.format("Allocation[adress=%d, size=%d]", this.adress, this.size);
    }

    public static void main(String[] args) {
        Allocation a1 = new Allocation(13, 10);
        Allocation a2 = new Allocation(314, 20);
        Allocation a3 = new Allocation(0126, 10);
        Allocation a4 = new Allocation(74, 20);
        Allocation a5 = new Allocation(74, 20);

        ArrayList<Allocation> list = new ArrayList<>();
        list.add(a1);
        list.add(a2);
        list.add(a3);
        list.add(a4);
        list.add(a5);

        LOG.info("Unsorted list:");
        for (Allocation a : list) {
            LOG.info(a.toString());
        }

        list.sort(ADRESS_COMPARATOR);
        LOG.info("Sorted list:");
        for (Allocation a : list) {
            LOG.info(a.toString());
        }

        LOG.info("a4 compareTo a5: " + a4.compareTo(a5));
    }
}
