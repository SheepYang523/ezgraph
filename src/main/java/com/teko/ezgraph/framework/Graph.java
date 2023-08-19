package com.teko.ezgraph.framework;

import java.util.Collection;
import java.util.HashSet;
import java.util.LinkedList;

/**
 * @param <T> The type of Graph's node.
 */
public interface Graph<T> {

    /**
     * @param u The node that needs to be put.
     * @param adjacency The adjacency nodes of u that will be in the graph.
     * @return Whether the operation is successful.
     */
    boolean putNode(T u, Collection<T> adjacency);

    /**
     * @param u The node that needs to be deleted.
     * @return The adjacency nodes of u.
     */
    HashSet<T> removeNode(T u);

    /**
     * @param u Check if u exists.
     * @return
     * exists: true
     * not exists: false.
     */
    boolean contains(T u);

    /**
     * @param us Check if graph contains all nodes within us.
     * @return
     * all exist: true
     * not all exists: false.
     */
    boolean containsAll(Collection<T> us);

    /**
     * @return
     * empty graph with no node and no edge: true
     * else: false
     */
    boolean isEmpty();

    /**
     * @return Count of nodes within graph.
     */
    long nodeSize();

    /**
     * @return Count of edges within graph.
     */
    long edgeSize();

    /**
     * Density can be defined by various graph types.
     * @return The density that defined by a specific graph type.
     */
    double density();
}
