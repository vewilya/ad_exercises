package ch.hslu.ad.sw03;

import java.util.List;

/**
 * Tree interface
 */
public interface TreeInterface<T> {

    /**
     * Adds an element to the tree.
     * 
     * @param the element to add
     * @return true if element was succesfully added to the tree, false otherwise
     */
    void add(T element);

    /**
     * Removes an element from the tree.
     * 
     * @param the element to remove
     * @return true if element was succesfully removed from the tree, false
     *         otherwise
     */
    boolean remove(T element);

    /**
     * Checks if the tree contains a certain element.
     * 
     * @param element element to check for.
     * @return true if the element was found, false otherwise
     */
    boolean search(T element);

    /**
     * Returns the height of the tree.
     * 
     * @return height of the tree as an integer value.
     */
    int getHeight();

    /**
     * Returns the order of the tree.
     * 
     * @return order of the tree as an integer value.
     */
    int getOrder();

    /**
     * Returns the weight of the tree, which is the the sum of all nodes.
     * 
     * @return weight of the tree as an integer
     */
    int getWeight();

    /**
     * Returns the path of a certain element in the tree.
     * 
     * @return path of a tree element as a list of elements that were passed by.
     */
    List<T> getPath(T element);

    /**
     * Returns the depth of a specific element in the tree.
     * 
     * @return depth of a specific element in the tree as an integer value.
     */
    int getDepth(T element);

    /**
     * Returns the degree of a specific element in the tree.
     * 
     * @return degree of a specific element in the tree as an integer value.
     */
    int getDegree(T element);

}
