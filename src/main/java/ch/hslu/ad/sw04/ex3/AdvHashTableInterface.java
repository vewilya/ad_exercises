package ch.hslu.ad.sw04.ex3;

/**
 * Interface for a basic Hash Table.
 *
 * @param <E>
 */
public interface AdvHashTableInterface<E> {

    /**
     * Add a specific element to the hashtable.
     *
     * @param element to add
     * @return true if the element was successfully added to the table, false otherwise.
     */
    boolean add(E element);

    /**
     * Remove a specific element from the hashtable.
     *
     * @param element to remove
     * @return true if the element was successfully removed from the hashtable, false otherwise.
     */
    boolean remove(E element);

    /**
     * Search for a specific element in the hashtable.
     *
     * @param element
     * @return true if element was found in the hashtable, false otherwise.
     */
    boolean search(E element);

}
