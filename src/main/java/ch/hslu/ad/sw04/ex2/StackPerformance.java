package ch.hslu.ad.sw04.ex2;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Stack;

public final class StackPerformance {
    private static final Logger LOG = LoggerFactory.getLogger(StackPerformance.class);

    public static Integer[] getArray(int size) {
        if (size <= 0) {
            throw new IllegalArgumentException();
        }

        Integer array[] = new Integer[size];

        for (Integer n = 0; n < size; n++) {
            array[n] = n;
        }

        return array;
    }

    public static void main(String[] args) {
        final int SIZE = 1000000;
        final double NANO_SEC_DIVISOR = 1000000000.0;
        final int NUM_ROUNDS = 4;

        final long[] myStackDurations = new long[NUM_ROUNDS];
        final long[] javaStackDurations = new long[NUM_ROUNDS];
        final long[] javaDequeDurations = new long[NUM_ROUNDS];

        IntegerStack myIntegerStack = new IntegerStack(SIZE);
        Stack<Integer> javaStack = new Stack<Integer>();
        javaStack.setSize(SIZE);

        Deque<Integer> javaDeque = new ArrayDeque<>();

        long startPoint = System.nanoTime();
        Integer array[] = StackPerformance.getArray(SIZE);
        long endPoint = System.nanoTime();

        LOG.info("Created Array in {} sec", (double) (endPoint - startPoint) / NANO_SEC_DIVISOR);
        LOG.info("------------------------------------------------");

        for (int i = 0; i < NUM_ROUNDS; i++) {
            LOG.info("------------------------------------------------");
            LOG.info("-----------------// ROUND {} //-----------------", i);
            LOG.info("------------------------------------------------");
            long startPointMyStack = System.nanoTime();
            for (int j = 0; j < SIZE; j++) {
                myIntegerStack.push(array[i]);
            }
            myStackDurations[i] = System.nanoTime() - startPointMyStack;

            LOG.info("Filled My Stack in {} sec", (double) (myStackDurations[i] / NANO_SEC_DIVISOR));
            LOG.info("------------------------------------------------");

            long startPointJavaStack = System.nanoTime();
            for (int j = 0; j < SIZE; j++) {
                javaStack.push(array[i]);
            }
            javaStackDurations[i] = System.nanoTime() - startPointJavaStack;

            LOG.info("Filled Java Stack in {} sec", (double) (javaStackDurations[i] / NANO_SEC_DIVISOR));
            LOG.info("------------------------------------------------");

            long startPointJavaDeque = System.nanoTime();
            for (int j = 0; j < SIZE; j++) {
                javaDeque.add(array[i]); /* Add at the end of the queue */
            }
            javaDequeDurations[i] = System.nanoTime() - startPointJavaDeque;

            LOG.info("Filled Java Deque in {} sec", (double) (javaDequeDurations[i] / NANO_SEC_DIVISOR));
            LOG.info("------------------------------------------------");

            myIntegerStack.clear();
            javaStack.clear();
            javaDeque.clear();

        }

        long myStackAverage = 0;
        long javaStackAverage = 0;
        long javaDequeAverage = 0;

        for (int i = 1; i < NUM_ROUNDS; i++) {
            myStackAverage += myStackDurations[i];
            javaStackAverage += javaStackDurations[i];
            javaDequeAverage += javaDequeDurations[i];
        }

        myStackAverage /= NUM_ROUNDS;
        javaStackAverage /= NUM_ROUNDS;
        javaDequeAverage /= NUM_ROUNDS;

        LOG.info("------------------------------------------------");
        LOG.info("Calculating average from the last 3 runs out of 4 - warm-up round doesnt count.");
        LOG.info("My Stack Average:     {}  seconds", myStackAverage / NANO_SEC_DIVISOR);
        LOG.info("Java Stack Average:   {}  seconds", javaStackAverage / NANO_SEC_DIVISOR);
        LOG.info("Java Deque Average:   {}  seconds", javaDequeAverage / NANO_SEC_DIVISOR);
    }

}
