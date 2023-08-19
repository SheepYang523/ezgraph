package com.teko.ezgraph.structure;

import com.teko.ezgraph.framework.AbstractIndexedGraph;

import java.util.Collection;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;

public class LightGraph extends AbstractIndexedGraph<LightNode> {
    private final HashMap<LightNode, HashSet<LightNode>> table = new HashMap<>();

    // Only add new node to graph
    @Override
    public boolean putNode(LightNode u, Collection<LightNode> adjacency /* if null put empty HashSet */) {
        if (u == null) return false;
        if (this.contains(u)) return false; // u must be a new node
        HashSet<LightNode> adj = new HashSet<>();
        this.table.put(u, adj);
        if (adjacency != null) {
            if (!this.containsAll(adjacency)) return false; // adjacency must be in graph
            adj.addAll(adjacency);
            for (LightNode v : adjacency) {
                this.addAdjacency(v, u);
            }
        }
        return true;
    }

    @Override
    public HashSet<LightNode> removeNode(LightNode u) {
        if (!this.contains(u)) return null;
        // remove all adjacency
        for (LightNode v : getAdjacency(u)) {
            if (v.equals(u)) continue;
            this.removeAdjacency(v, u);
        }
        HashSet<LightNode> ret = this.getAdjacency(u);
        this.table.remove(u);
        return ret;
    }

    // Only connect two existing node in graph
    public boolean putEdge(LightNode u, LightNode v) {
        if (!(this.contains(u) && this.contains(v))) return false;  // require u and v both in graph
        if (this.containsAdjacency(u, v)) return false;
        this.addAdjacency(u, v);
        this.addAdjacency(v, u);
        return true;
    }

    public boolean removeEdge(LightNode u, LightNode v) {
        if (!(this.contains(u) && this.contains(v))) return false;  // require u and v both in graph
        if (!this.containsAdjacency(u, v)) return false;
        this.removeAdjacency(u, v);
        this.removeAdjacency(v, u);
        return true;
    }

    public boolean containsEdge(LightNode u, LightNode v) {
        if (!(this.contains(u) && this.contains(v))) return false;
        return this.containsAdjacency(u, v);
    }

    private void addAdjacency(LightNode u, LightNode v) {
        this.table.get(u).add(v);
    }

    private void removeAdjacency(LightNode u, LightNode v) {
        this.table.get(u).remove(v);
    }

    private HashSet<LightNode> getAdjacency(LightNode u) {
        return this.table.get(u);
    }

    @Override
    public boolean contains(LightNode u) {
        return this.table.containsKey(u);
    }

    @Override
    public boolean containsAll(Collection<LightNode> us) {
        return this.table.keySet().containsAll(us);
    }

    private boolean containsAdjacency(LightNode u, LightNode v) {
        return this.table.get(u).contains(v);
    }

    @Override
    public boolean isEmpty() {
        return this.table.isEmpty();
    }

    @Override
    public long nodeSize() {
        return this.table.size();
    }

    @Override
    public long edgeSize() {
        long count = 0;
        for (LightNode u : this.table.keySet())
            count += this.table.get(u).size();
        return count / 2;
    }

    @Override
    public double density() {
        return (double) this.edgeSize() / (double) this.nodeSize();
    }

    @Override
    public String toString() {
        return this.table.toString();
    }
}
