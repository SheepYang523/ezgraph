package com.teko;

import com.teko.ezgraph.pool.LightNodeFactory;
import com.teko.ezgraph.structure.LightGraph;
import com.teko.ezgraph.structure.LightNode;
import org.junit.Test;

import java.util.Random;

/**
 * Unit test for simple App.
 */
public class AppTest {
    @Test
    public void IntegerTest() {
        Random rd = new Random();
        rd.setSeed(System.currentTimeMillis());
        for (int i = 0; i < 100; i++)
            System.out.print(rd.nextInt(0, 100) + " ");
    }

    @Test
    public void GraphTest() {
        LightGraph graph = new LightGraph();
        LightNodeFactory factory = new LightNodeFactory();
        for (int i = 0; i < 10; i++) {
            graph.putNode(factory.fetch(i), null);
        }
        Random rd = new Random();
        rd.setSeed(System.currentTimeMillis());

        int cnt = 0;
        while (cnt < 20) {
            int u = rd.nextInt(0, 100);
            int v = rd.nextInt(0, 100);
            if (!graph.putEdge(factory.fetch(u), factory.fetch(v))) continue;
            System.out.println(graph);
            graph.removeEdge(factory.fetch(u), factory.fetch(v));
            cnt++;
        }
        System.out.println(graph.edgeSize());
        System.out.println(graph.nodeSize());
        System.out.println(graph.density());
        System.out.println(graph);
        for (int i = 0; i < 10; i++) {
            graph.removeNode(factory.fetch(i));
            System.out.println(graph);
        }
    }
}
