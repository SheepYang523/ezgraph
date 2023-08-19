package com.teko.ezgraph.framework;

public abstract class AbstractIndexedGraph<T extends IndexedNode> implements Graph<T> {
    // Collection<IndexedNode> container
    // here is no restrictions on the index type, as long as <T> is instance of IndexedNode.
    // Integer
    // Long
    // BigInteger
    // ...

    // here is also no the restrictions on the data structure of container
}
