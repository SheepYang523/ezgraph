package com.teko.pool;

import com.teko.framework.IndexedNode;
import com.teko.framework.Node;

import java.util.*;

public abstract class AbstractNodeFactory<E extends IndexedNode<?>> implements NodeFactory<E> {
    protected final HashMap<Number, E> pool = new HashMap<>();
}
