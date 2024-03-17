package ch.hslu.ad.sw01.MemoryDemo;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

import nl.jqno.equalsverifier.EqualsVerifier;
import nl.jqno.equalsverifier.Warning;

public class AllocationTest {
    @Test
    void testEqualsContract() {
        EqualsVerifier.forClass(Allocation.class).suppress(Warning.NONFINAL_FIELDS)
                .withOnlyTheseFields("adress", "size")
                .verify();
    }

    @Test
    void testCompareTo() {
        Allocation a1 = new Allocation(0123, 10);
        Allocation a2 = new Allocation(0314, 20);

        assert (a1.compareTo(a2) < 0);
    }

    @Test
    void testCompareTo2() {
        Allocation a1 = new Allocation(0123, 10);
        Allocation a3 = new Allocation(0123, 10);

        assertEquals(a1.compareTo(a3), 0);
    }

    @Test
    void testEquals() {
        Allocation a1 = new Allocation(0123, 10);
        Allocation a3 = new Allocation(0123, 10);

        assert (a1.equals(a3));
    }

    @Test
    void testHashCode() {
        Allocation a1 = new Allocation(0123, 10);
        Allocation a3 = new Allocation(0123, 10);

        assertEquals(a1.hashCode(), a3.hashCode());
    }

    @Test
    void testGetAdress() {
        Allocation a1 = new Allocation(0123, 10);

        assertEquals(a1.getAdress(), 0123);
    }

    @Test
    void testGetSize() {
        Allocation a1 = new Allocation(0123, 10);

        assertEquals(a1.getSize(), 10);
    }

}
