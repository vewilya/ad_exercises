package ch.hslu.ad.sw01.Fibonacci;

import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.ArrayList;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public final class Fibonacci {
    
    private static int f0 = 0;
    private static int f1 = 1;

    private static ArrayList<Long> fibonacciList = new ArrayList<>(100);
    private static final Logger LOG = LoggerFactory.getLogger("Fibonacci");

    public static long fiboRec1(final int n) {
        if (n == 0) {
            return f0;
        } else if (n == 1) {
            return f1; // Rekursionsbasis
        } else {
            return fiboRec1(n - 1) + fiboRec1(n - 2); // Rekursionsvorschrift
        }
    }
    // public static long fiboRec1_corrected(final int n) {
        
    //     if (n <= 1) {
    //         return n; // Rekursionsbasis
    //     } else {
    //         return fiboRec1(n - 1) + fiboRec1(n - 2); // Rekursionsvorschrift
    //     }
    // }

    public static long fiboRec2(final int n) {
        if (n == 0) {
            return f0;
        } else if (n == 1) {
            return f1; // Rekursionsbasis
        } else {
            if (fibonacciList.get(n) != -1) {
                // LOG.info("getting list value for {}", n);
                return fibonacciList.get(n);
            }

            long fibo = fiboRec2(n - 1) + fiboRec2(n - 2);
            fibonacciList.set(n, fibo); // Rekursionsvorschrift
            // LOG.info("recursive calc value for {}", n);

            return fibo;
        }
    }

    // COPILOT
    public static long fiboIter1(final int n) {
        int f = 0;
        int g = 1;

        for (int i = 0; i < n; i++) {
            f = f + g;
            g = f - g;
        }

        return f;
    }

    // ME OWN CRAP
    public static long fiboIter2(final int n) {
        int f0 = 0;
        int f1 = 1;
        int fibo = 0;

        for (int i = 0; i < n - 1; i++) {
            fibo = f0 + f1;
            f0 = f1;
            f1 = fibo;
        }

        return fibo;
    }

    private static void initFibonacciList(final int size) {
        for (int i = 0; i < size; i++) {
            if (i == 0)
                fibonacciList.add(0l);
            else if (i == 1)
                fibonacciList.add(1l);
            else
                fibonacciList.add(-1l);
        }
    }

    public static void printFibonacciList() {
        LOG.info("Fibonacci List: {}", fibonacciList);
    }

    public static void task() {
        
        try (PrintWriter writer = new PrintWriter("src/main/java/ch/hslu/ad/sw01/Fibonacci/listTime.txt")) {
            
            int n = 10;

            while (n < 50) {
                
                long startTime1 = System.currentTimeMillis();
                LOG.info("Result for fiboRec1 = {}", fiboRec1(n));
                long timePassed1 = System.currentTimeMillis() - startTime1;
                LOG.info("T(n) for fiboRec1 = {} ms", timePassed1);
        
                long startTime2 = System.currentTimeMillis();
                LOG.info("Result for fiboRec2 = {}", fiboRec2(n));
                long timePassed2 = System.currentTimeMillis() - startTime2;
                LOG.info("T(n) for fiboRec2 = {} ms", timePassed2);
        
                long startTime3 = System.currentTimeMillis();
                LOG.info("Result for fiboIter1 = {}", fiboIter1(n));
                long timePassed3 = System.currentTimeMillis() - startTime3;
                LOG.info("T(n) for fiboIter1 = {} ms", timePassed3);
        
                long startTime4 = System.currentTimeMillis();
                LOG.info("Result for fiboIter1 = {}",  fiboIter2(n));
                long timePassed4 = System.currentTimeMillis() - startTime4;
                LOG.info("T(n) for fiboIter2 = {} ms", timePassed4);
    
                writer.println("----------------------------------------------");
                writer.println("n: " + n + ", Algorithm: fiboRec1" + ", time: " + timePassed1);
                writer.println("n: " + n + ", Algorithm: fiboRec2" + ", time: " + timePassed2);
                writer.println("n: " + n + ", Algorithm: fiboIter1" + ", time: " + timePassed3);
                writer.println("n: " + n + ", Algorithm: fiboIter2" + ", time: " + timePassed4);
    
                n += 3;
            }

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        initFibonacciList(100);
        task();
    }
}

