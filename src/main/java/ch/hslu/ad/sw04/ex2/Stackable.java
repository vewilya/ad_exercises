package ch.hslu.ad.sw04.ex2;

/**
 * The Stackable interface represents a stack data structure that can hold
 * elements of type T.
 *
 * @param <T> the type of elements in the stack
 */
public interface Stackable<T> {

    /**
     * Removes and returns the top element from the stack.
     *
     * @return the top element from the stack
     */
    T pop();

    /**
     * Pushes an element onto the top of the stack.
     *
     * @param element the element to be pushed onto the stack
     */
    boolean push(T element);

    /**
     * Checks if the stack is empty.
     *
     * @return true if the stack is empty, false otherwise
     */
    boolean isEmpty();

    /**
     * Checks if the stack is full.
     *
     * @return true if the stack is full, false otherwise
     */
    boolean isFull();

    /**
     * Returns the current size of the stack.
     *
     * @return the current size of the stack
     */
    int getSize();

    /**
     * Clears the stack of all containing elements.
     */
    void clear();
}
