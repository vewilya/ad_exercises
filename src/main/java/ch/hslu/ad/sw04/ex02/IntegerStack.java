package ch.hslu.ad.sw04.ex02;

import java.util.Arrays;

public class IntegerStack implements Stackable<Integer> {
    private int stackCapacity;
    private Integer[] elements;
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

            return null;
        }

    }

    @Override
    public void push(Integer element) {
        try {
            elements[stackPointer] = element;
            stackPointer++;
        } catch (IndexOutOfBoundsException iabe) {
            System.out.println("The stack is full!");
        }
    }

    @Override
    public void setStackCapacity(int maxStackSize) {
        this.stackCapacity = maxStackSize;
    }

    @Override
    public void clear() {
//        elements = new Integer[stackCapacity];
        for (int i = 0; i < stackCapacity; i++) {
            elements[i] = null;
        }

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
        return elements[stackCapacity - 1] != null;
    }

    @Override
    public String toString() {
        return "Stack [elements=" + Arrays.toString(elements) + ", stackCapacity=" + stackCapacity + "]";
    }

}
