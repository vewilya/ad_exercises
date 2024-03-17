package ch.hslu.ad.sw02;

import java.util.Arrays;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class Stack implements Stackable<String> {

    private int stackCapacity;
    private String[] elements;
    private int stackPointer;

    private static final Logger LOG = LoggerFactory.getLogger(Stack.class);

    public Stack() {
        this.initStack(100);
        stackPointer = 0;
    }

    public Stack(int capacity) {
        this.initStack(capacity);
        stackPointer = 0;
    }

    private void initStack(int stackSize) {
        this.setStackCapacity(stackSize);
    }

    @Override
    public String pop() {
        try {
            String element = elements[stackPointer - 1];
            LOG.info("Popping out element {} at index {}", element, stackPointer - 1);
            elements[stackPointer - 1] = null;
            stackPointer--;

            return element;
        } catch (IndexOutOfBoundsException iabe) {
            LOG.error("The stack is already empty!");
            return null;
        }

    }

    @Override
    public void push(String element) {
        try {
            elements[stackPointer] = element;
            LOG.info("Pushing element {} at index {}", element, stackPointer);
            stackPointer++;
        } catch (IndexOutOfBoundsException iabe) {
            LOG.error("The stack is full!");
        }
    }

    @Override
    public void setStackCapacity(int maxStackSize) {
        this.stackCapacity = maxStackSize;
        elements = new String[maxStackSize];
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

    public static void main(String[] args) {
        Stack stack = new Stack(1);

        stack.push("Hello");
        stack.pop();
        stack.pop();

    }

}
