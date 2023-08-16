package com.teko;

import com.teko.pool.LightNodeFactory;
import com.teko.structure.LightNode;
import junit.framework.TestCase;
import junit.framework.TestSuite;
import org.junit.Test;

import java.io.PrintWriter;
import java.io.Serial;
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
        LightNodeFactory factory = new LightNodeFactory();
        for (int i = 0; i < 4096; i++) {
            LightNode node = factory.fetch(i);
            System.out.println(node);
        }
    }
}
