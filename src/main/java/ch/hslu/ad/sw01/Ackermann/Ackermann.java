package ch.hslu.ad.sw01.Ackermann;

public class Ackermann {

    public Ackermann() {}
    public static int counter = 0;

    public final int getCounter() {
        return counter;
    }
    public final int ack(int n, int m) {
        counter++;
        if (n == 0)
            return (m + 1);
        else if (m == 0)
            return ack(n - 1, 1);
        else
            return ack(n - 1, ack(n, m - 1));
    }
}