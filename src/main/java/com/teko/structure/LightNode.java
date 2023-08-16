package com.teko.structure;

import com.teko.framework.AbstractIndexedNode;
import com.teko.framework.IndexedNode;

import java.io.Serial;

public class LightNode extends AbstractIndexedNode<Integer> {
    @Serial
    private static final long serialVersionUID = -4749038060172279812L;

    public LightNode(Integer index) {
        this.index = index;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == null) return false;
        if (obj == this) return true;
        if (obj instanceof LightNode) {
            return ((LightNode) obj).getIndex().equals(this.index);
        }
        return false;
    }

    @Override
    public String toString() {
        return this.index.toString();
    }

    @Override
    public Integer getIndex() {
        return this.index;
    }

    private int compare(LightNode x, LightNode y) {
        return x.index.compareTo(y.index);
    }

    @Override
    public int compareTo(AbstractIndexedNode<Integer> o) {
        if (o == null) throw new NullPointerException();
        if (!(o instanceof LightNode)) throw new ClassCastException();
        return this.compare(this, (LightNode) o);
    }
}
