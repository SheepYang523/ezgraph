package com.teko.structure;

import com.teko.framework.AbstractIndexedNode;

import java.io.Serial;

public class HeavyNode extends AbstractIndexedNode<Long> {
    @Serial
    private static final long serialVersionUID = -144079560172488048L;

    @Override
    public boolean equals(Object obj) {
        if (obj == null) return false;
        if (obj == this) return true;
        if (obj instanceof HeavyNode) {
            return ((HeavyNode) obj).getIndex().equals(this.index);
        }
        return false;
    }

    @Override
    public String toString() {
        return this.index.toString();
    }

    @Override
    public Long getIndex() {
        return this.index;
    }

    private int compare(HeavyNode x, HeavyNode y) {
        if (x == null || y == null) throw new NullPointerException();
        return x.index.compareTo(y.index);
    }

    @Override
    public int compareTo(AbstractIndexedNode<Long> o) {
        if (!(o instanceof HeavyNode)) throw new ClassCastException();
        return this.compare(this, (HeavyNode) o);
    }
}
