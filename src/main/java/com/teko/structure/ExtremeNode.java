package com.teko.structure;

import com.teko.framework.AbstractIndexedNode;

import java.io.Serial;
import java.math.BigInteger;

public class ExtremeNode extends AbstractIndexedNode<BigInteger> {
    @Serial
    private static final long serialVersionUID = -7443414461563149324L;

    @Override
    public boolean equals(Object obj) {
        if (obj == null) return false;
        if (obj == this) return true;
        if (obj instanceof ExtremeNode) {
            return ((ExtremeNode) obj).getIndex().equals(this.index);
        }
        return false;
    }

    @Override
    public String toString() {
        return this.index.toString();
    }

    @Override
    public BigInteger getIndex() {
        return this.index;
    }

    private int compare(ExtremeNode x, ExtremeNode y) {
        if (x == null || y == null) throw new NullPointerException();
        return x.index.compareTo(y.index);
    }

    @Override
    public int compareTo(AbstractIndexedNode<BigInteger> o) {
        if (!(o instanceof ExtremeNode)) throw new ClassCastException();
        return this.compare(this, (ExtremeNode) o);
    }
}
