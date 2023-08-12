package com.teko.framework;

import java.io.Serial;
import java.io.Serializable;

public abstract class AbstractIENode<T extends Number, E>
        implements IndexedNode<T>, EntitiedNode<E>, Comparable<AbstractIENode<T, E>>, Serializable {
    @Serial
    private static final long serialVersionUID = -2127429804903225602L;
    protected T index;
    protected E entity;

    @Override
    protected Object clone() throws CloneNotSupportedException {
        throw new CloneNotSupportedException();
    }

    @Override
    public abstract boolean equals(Object obj);

    @Override
    public abstract String toString();

    @Override
    public abstract E getEntity();

    @Override
    public abstract T getIndex();

    @Override
    public abstract int compareTo(AbstractIENode<T, E> o);
}
