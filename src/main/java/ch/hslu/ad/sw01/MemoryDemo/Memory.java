package ch.hslu.ad.sw01.MemoryDemo;

public interface Memory {

    /**
     * Allocates a memory block of the given size.
     * 
     * @param size the size of the memory block to allocate.
     * @return the address of the allocated memory block.
     * @throws OutOfMemoryError if not enough memory is available.
     */
    Allocation malloc(int size);

    /**
     * Releases the memory block at the given address.
     * 
     * @param address the address of the memory block to release.
     * @throws IllegalArgumentException if the address is invalid.
     */
    void free(int address);
}