package com.teko.framework;

import com.teko.pool.AbstractNodeFactory;

import java.io.Serial;
import java.io.Serializable;

public abstract class AbstractIndexedNode<T extends Number>
        implements IndexedNode<T>, Comparable<AbstractIndexedNode<T>>, Serializable {
    @Serial
    private static final long serialVersionUID = -6749912138869759574L;
    protected T index;


    @Override
    protected Object clone() throws CloneNotSupportedException {
        throw new CloneNotSupportedException();
    }

    @Override
    public abstract boolean equals(Object obj);

    @Override
    public abstract String toString();

    @Override
    public abstract T getIndex();

    @Override
    public abstract int compareTo(AbstractIndexedNode<T> o);
}
