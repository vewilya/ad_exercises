package ch.hslu.ad.sw02;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

public class StackTest {
    @Test
    void testConstructor() {
        Stack stack = new Stack();
        assertEquals(true, stack.isEmpty());
    }

    @Test
    void testConstructor2() {
        Stack stack = new Stack(1);
        stack.push("Filling up the stack");
        assertEquals(false, stack.isEmpty());
    }

    @Test
    void testConstructorFullStack() {
        Stack stack = new Stack(1);
        stack.push("Filling up the stack");
        assertEquals(true, stack.isFull());
    }

    @Test
    void testConstructorFullStack2() {
        Stack stack = new Stack(1);
        stack.push("Filling up the stack");
        stack.push("too much");
        assertEquals(true, stack.isFull());
    }

    @Test
    void testPop() {
        Stack stack = new Stack(1);
        stack.push("Filling up the stack");
        assertEquals("Filling up the stack", stack.pop());
    }

    @Test
    void testPopEmptyStack() {
        Stack stack = new Stack(1);
        assertEquals(null, stack.pop());
    }

    @Test
    void testPush() {
        Stack stack = new Stack(10);
        stack.push("New1");
        stack.push("New2");
        stack.push("New3");
        stack.push("New4");
        stack.push("New5");
        // stack.pop();
        assertEquals(5, stack.getSize());
    }

    // @Disabled
    // void testExceptionHandlingWithAssertJ() {
    // Stack stack = new Stack(1);
    // stack.push("New1");

    // assertThatThrownBy(() -> {
    // new Stack(1).push("New2");
    // }).isInstanceOf(IndexOutOfBoundsException.class).hasMessage("The stack is
    // full!");

    @Test
    void testSetCapacity() {
        Stack stack = new Stack(3);
        stack.push("New1");
        stack.push("New2");
        stack.push("New3");
        System.out.println(stack);
        assertEquals(3, stack.getSize());
    }
}
