package com.teko.ezgraph.pool;

import com.teko.ezgraph.framework.IndexedNode;

import java.util.*;

public abstract class AbstractNodeFactory<E extends IndexedNode<?>> implements NodeFactory<E> {
    protected final HashMap<Number, E> pool = new HashMap<>();
}
