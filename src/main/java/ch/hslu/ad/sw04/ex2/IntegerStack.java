package ch.hslu.ad.sw04.ex2;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Arrays;

public class IntegerStack implements Stackable<Integer> {
    private static final Logger LOG = LoggerFactory.getLogger(IntegerStack.class);
    private final Integer[] elements;
    private int STACK_SIZE;
    private int stackPointer;

    public IntegerStack() {
        elements = new Integer[100];
        stackPointer = 0;
    }

    public IntegerStack(int capacity) {
        elements = new Integer[capacity];
        stackPointer = 0;
    }

    @Override
    public Integer pop() {
        try {
            Integer element = elements[stackPointer - 1];
            elements[stackPointer - 1] = null;
            stackPointer--;

            return element;
        } catch (IndexOutOfBoundsException iabe) {
            LOG.info("The stack is empty!");
            return null;
        }

    }

    @Override
    public boolean push(Integer element) {
        try {
            elements[stackPointer] = element;
            stackPointer++;
            return true;
        } catch (IndexOutOfBoundsException iabe) {
            LOG.info("The stack is full!");
            return false;
        }
    }

    @Override
    public void clear() {
        for (int i = 0; i < STACK_SIZE; i++) {
            elements[i] = null;
        }

//        elements = new Integer[STACK_SIZE];

        stackPointer = 0;
    }

    @Override
    public int getSize() {
        return this.stackPointer;
    }

    @Override
    public boolean isEmpty() {
        return elements[0] == null;
    }

    @Override
    public boolean isFull() {
        return elements[STACK_SIZE - 1] != null;
    }

    @Override
    public String toString() {
        return "Stack [elements=" + Arrays.toString(elements) + ", stackCapacity=" + STACK_SIZE + "]";
    }

}
