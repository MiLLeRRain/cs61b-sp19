import java.util.*;

public class UnionFind {
    private int[] parent;

    /* Creates a UnionFind data structure holding n vertices. Initially, all
       vertices are in disjoint sets. */
    public UnionFind(int n) {
        parent = new int[n];
        Arrays.fill(parent, -1);
    }

    /* Throws an exception if v1 is not a valid index. */
    private void validate(int v) {
        if (v<0 || v>parent.length-1) {throw new IllegalArgumentException("v1 is not valid index");}
    }

    /* Returns the size of the set v1 belongs to. */
    public int sizeOf(int v) {
        validate(v);
        return -parent(find(v));
    }

    /* Returns the parent of v1. If v1 is the root of a tree, returns the
       negative size of the tree for which v1 is the root. */
    public int parent(int v) {
        validate(v);
        return parent[v];
    }

    /* Returns true if nodes v1 and v2 are connected. */
    public boolean connected(int v1, int v2) {
        validate(v1);
        validate(v2);
        return find(v1) == find(v2);
    }

    /* Connects two elements v1 and v2 together. v1 and v2 can be any valid 
       elements, and a union-by-size heuristic is used. If the sizes of the sets
       are equal, tie break by connecting v1's root to v2's root. Unionising a
       vertex with itself or vertices that are already connected should not 
       change the sets but may alter the internal structure of the data. */
    public void union(int v1, int v2) {
        validate(v1);
        validate(v2);
        if (v1 == v2 || connected(v1, v2)) {return;}
        if (sizeOf(v1) > sizeOf(v2)) union(v2, v1);
        else {
            int rootV1 = find(v1);
            int rootV2 = find(v2);
            int sizeUp = sizeOf(v1);
            parent[rootV1] = rootV2;
            parent[rootV2] -= sizeUp;
        }
    }

    /* Returns the root of the set V belongs to. Path-compression is employed
       allowing for fast search-time. */
    public int find(int v) {
        validate(v);
        if (parent[v] < 0) return v;
        else return parent[v] = find(parent[v]);
    }

}
