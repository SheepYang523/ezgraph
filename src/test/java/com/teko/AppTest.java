package com.teko;

import com.teko.ezgraph.pool.LightNodeFactory;
import com.teko.ezgraph.structure.LightNode;
import org.junit.Test;

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
