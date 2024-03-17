package ch.hslu.ad.sw01.Ackermann;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class AckermannTest {

    @Test
    void testAck1() {
        Ackermann am = new Ackermann();
        System.out.println(am.ack(2, 2));
        System.out.println(am.getCounter());
    }

    @Test
    void testAck2() {
        Ackermann am = new Ackermann();
        System.out.println(am.ack(2, 1));
        System.out.println(am.getCounter());
    }
}