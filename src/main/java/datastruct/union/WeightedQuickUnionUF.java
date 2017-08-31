package datastruct.union;

public class WeightedQuickUnionUF {
    private int[] id;
    private int[] size;
    private int count;

    public WeightedQuickUnionUF(Integer count) {
        this.count = count;
        size = new int[count];
        id = new int[count];
        for (int i = 0; i < count; i++) {
            id[i] = i;
        }
        for (int i = 0; i < count; i++) {
            size[i] = 1;
        }
    }


    //return true if p and q are in the same component
    public boolean connected(int p, int q) {
        return find(p) == find(q);
    }

    // Follow links to find a root.
    public int find(int p) {
        while (p != id[p]) {
            p = id[p];
        }
        return p;
    }

    public int count() {
        return count;
    }

    public void union(int p, int q) {
        int pId = find(p);
        int qId = find(q);
        if (pId == qId) {
            return;
        }
        // Make smaller root point to larger one.
        if (size[pId] < size[qId]) {
            id[pId] = qId;
            size[qId] += size[pId];
        } else {
            id[qId] = pId;
            size[pId] += size[qId];
        }
        count--;

    }
    //
}
