package com.teko.pool;

import com.teko.structure.LightNode;

import java.io.PrintWriter;
import java.io.Serial;

public class LightNodeFactory extends AbstractNodeFactory<LightNode> {

    /**
     * if touch the FetchException when fetching, the whole program will stop.
     * @param index the index of node to be fetched
     * @return node to be fetched
     */
    public LightNode fetch(Integer index) {
        if (!(this.pool.containsKey(index))) {
            boolean feedback = this.add(index); // adding success or not.
            if (!feedback) throw new FetchException("Fail while adding a not existing node.");
        }
        LightNode target = this.pool.get(index);
        if (target == null) {
            throw new FetchException("Target node being gotten is null");
        } else {
            return target;
        }
    }

    private boolean add(Integer index) {
        if (index == null) throw new NullPointerException();
        try {
            LightNode newNode = new LightNode(index);
            this.pool.put(index, newNode);
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
        return true;
    }

    private LightNode get(Integer index) {
        if (index == null) throw new NullPointerException();
        return this.pool.getOrDefault(index, null);
    }

    private static class FetchException extends RuntimeException {
        @Serial
        private static final long serialVersionUID = 3469485669985353219L;

        public FetchException(String message) {
            super(message);
        }

        @Override
        public void printStackTrace() {
            super.printStackTrace();
        }

        @Override
        public void printStackTrace(PrintWriter s) {
            super.printStackTrace(s);
        }
    }
}
