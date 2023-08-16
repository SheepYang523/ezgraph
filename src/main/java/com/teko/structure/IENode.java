package com.teko.structure;

import com.teko.framework.AbstractIENode;

import java.io.Serial;
import java.math.BigInteger;
import java.nio.file.ProviderMismatchException;

public class IENode<T extends Number, E> extends AbstractIENode<T, E> {
    @Serial
    private static final long serialVersionUID = -6675156481740991022L;

    public IENode(T index, E entity) {
        this.index = index;
        this.entity = entity;
    }

    @Override
    public boolean equals(Object obj) {
        return false;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(this.index.toString())
                .append(" -> ")
                .append(this.entity.toString());
        return sb.toString();
    }

    @Override
    public E getEntity() {
        return this.entity;
    }

    @Override
    public T getIndex() {
        return this.index;
    }

    /**
     * Limit: T in {Integer, Long, BigInteger}
     * @param x one
     * @param y another
     * @return
     * x < y -1
     * x = y 0
     * x > y 1
     */
    private int compare(IENode<T, E> x, IENode<T, E> y) {
        if (x == null || y == null) throw new NullPointerException();
        if (x.index instanceof Integer || x.index instanceof Long || x.index instanceof BigInteger) {
            return ((Integer) x.index).compareTo((Integer) y.index);
        }
        else {
            throw new ProviderMismatchException();
        }
    }

    @Override
    public int compareTo(AbstractIENode<T, E> o) {
        if (!(o instanceof IENode<T, E>)) throw new ClassCastException();
        return this.compare(this, (IENode<T, E>) o);
    }
}
