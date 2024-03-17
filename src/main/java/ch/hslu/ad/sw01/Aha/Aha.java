package ch.hslu.ad.sw01.Aha;

import java.io.FileNotFoundException;
import java.io.PrintWriter;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public final class Aha {
    private static final Logger LOG = LoggerFactory.getLogger(Aha.class);

    private static int counter = 0;
    private static int timePassed = 0;

    public static void task(final int n) {
        long start = System.currentTimeMillis();
        task1();
        task1();
        task1();
        task1(); // T ~ 4

        for (int i = 0; i < n; i++) { // äussere Schleife: n-mal
            task2();
            task2();
            task2(); // T ~ n · 3
            for (int j = 0; j < n; j++) { // innerer Schleife: n-mal
                task3();
                task3(); // T ~ n · n· 2
            }
        }

        long time = (int) (System.currentTimeMillis() - start);
        timePassed += time;
        LOG.info("T(n) = {} ms", timePassed);
    }

    public static void task1() {
        counter++;

        try {
            Thread.sleep(5);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public static void task2() {
        counter++;

        try {
            Thread.sleep(5);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public static void task3() {
        counter++;

        try {
            Thread.sleep(5);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        int n = 1;

        // for (int i = 0; i < 10; i++) {
        // task(n);
        // n *= 2;
        // LOG.info("n: {}, counter: {}, time passed: {}", n, counter, timePassed);
        // }

        // Nicht sauber nach Gisler! Aber funktioniert trotzdem...
        try (PrintWriter writer = new PrintWriter("src/main/java/ch/hslu/ad/sw01/Aha/listTime.txt")) {
            writer.println("n,counter");
            for (int i = 0; i < 7; i++) {
                task(n);
                writer.println("n: " + n + ", counter: " + counter + ", time: " + timePassed);
                LOG.info("n: {}, counter: {}, time passed: {}", n, counter, timePassed);
                n *= 2;
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }

    }
}
