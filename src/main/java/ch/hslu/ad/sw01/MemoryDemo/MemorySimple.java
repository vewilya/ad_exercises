package ch.hslu.ad.sw01.MemoryDemo;

public class MemorySimple implements Memory {
    private final int size;
    private int used;
    private int free;

    public MemorySimple(final int size) {
        this.size = size;
        this.used = 0;
        this.free = size;
    }

    public int getSize() {
        return size;
    }

    public int getUsed() {
        return used;
    }

    public int getFree() {
        return free;
    }

    public Allocation malloc(final int size) {
        if (size > this.size) {
            throw new IllegalArgumentException("Size exceeds memory");
        }

        if (size > free) {
            throw new IllegalArgumentException("Not enough memory");
        }

        used += size;

        return new Allocation(used - size, size);
    }

    public static void main(String[] args) {
        MemorySimple memory = new MemorySimple(1024);
    }

    @Override
    public void free(int address) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'free'");
    }
}
