package ch.hslu.ad.sw04.ex2;

import org.junit.jupiter.api.Test;

import java.util.Random;

import static org.junit.jupiter.api.Assertions.*;

class IntegerStackTest {

    Random random = new Random();
    IntegerStack intStack = new IntegerStack(10);
    
    @Test
    void push() {
        intStack.push(3);
        intStack.push(9);

        assertEquals(2, intStack.getSize());
    }

    @Test
    void pop() {
        intStack.push(4);
        intStack.push(9);
        intStack.push(149);
        intStack.push(643);

        assertEquals(643, intStack.pop());
        assertEquals(149, intStack.pop());
        assertEquals(9, intStack.pop());
        assertEquals(4, intStack.pop());

        /* Stack is empty */
        assertNull(intStack.pop());
    }

    @Test
    void clear() {
        intStack.push(4);
        intStack.push(9);
        intStack.push(149);
        intStack.push(643);

        intStack.clear();
        assertEquals(0, intStack.getSize());

    }

    @Test
    void getSize() {
        intStack.push(4);
        intStack.push(9);
        intStack.push(149);
        intStack.push(643);
        intStack.push(645);
        intStack.push(17774);
        intStack.push(612);

        assertEquals(7, intStack.getSize());
    }

    @Test
    void isEmpty() {
        assertEquals(0, intStack.getSize());
    }

    @Test
    void isFull() {
        for (int i = 0; i < 10; i++) {
            intStack.push(random.nextInt(545));
        }

        assertFalse(intStack.push(5));

    }
}