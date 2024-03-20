package ch.hslu.ad.sw05;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class Test {
    private static final Logger LOG = LoggerFactory.getLogger(Test.class);

    public static void main(String[] args) {
        final int nr = Runtime.getRuntime().availableProcessors();
        long mem = Runtime.getRuntime().freeMemory();
        LOG.info("Threads: {}", nr);
        LOG.info("Memory: {}", mem);
    }
}
