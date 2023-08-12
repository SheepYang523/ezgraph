package com.teko;

import junit.framework.TestCase;
import junit.framework.TestSuite;
import org.junit.Test;

import java.math.BigInteger;
import java.util.Comparator;
import java.util.List;
import java.util.PriorityQueue;

/**
 * Unit test for simple App.
 */
public class AppTest {
    @Test
    public void IntegerTest() {
        PriorityQueue<Frequency> q = new PriorityQueue<>(10, Comparator.comparingInt(x -> x.count));
        Frequency f = new Frequency(1);
        Frequency d = new Frequency(-100);
        q.add(new Frequency(2));
        q.add(new Frequency(3));
        q.add(new Frequency(6));
        q.add(f);
        q.add(new Frequency(5));
        q.add(new Frequency(9));


        f.count = 7;
        q.add(d);
        q.remove(d);

        int k = q.size();
        for (int i = 0; i < k; i++) {
            System.out.println(q.poll().count);
        }
    }

    private static class Frequency {
        public Number id;
        public int count;

        public Frequency(int c) {
            this.count = c;
            this.id = null;
        }
    }
}
