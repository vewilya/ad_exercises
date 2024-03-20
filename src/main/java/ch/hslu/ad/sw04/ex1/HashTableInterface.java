package ch.hslu.ad.sw04.ex1;

/**
 * Interface for a basic generic Hash Table.
 *
 * @param <E>
 */
public interface HashTableInterface<E> {

    /**
     * Add a specific element to the hashtable.
     *
     * @param element to add
     */
    void add(E element);

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
