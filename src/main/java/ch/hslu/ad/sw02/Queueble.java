package ch.hslu.ad.sw02;

/**
 * Interface for a generic queue.
 */
public interface Queueble<T> {

    /**
     * Add an element to the queue.
     * 
     * @param element element to add
     * @return true if the element was added, false if the queue is full
     */
    boolean offer(T element);

    /**
     * Remove and return the first element from the queue.
     * 
     * @return the first element in the queue
     */
    T poll();

    /**
     * Check if the queue is empty.
     * 
     * @return true if the queue is empty, false otherwise
     */
    boolean isEmpty();

    /**
     * Check if the queue is full.
     * 
     * @return true if the queue is full, false otherwise
     */
    boolean isFull();

    /**
     * Get the size of the queue.
     * 
     * @return the size of the queue
     */
    int getSize();

}
