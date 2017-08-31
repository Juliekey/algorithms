package datastruct.union;

public class UF {
    private int[] id;
    private int count;

    //initialize N sites with integer names (0 to N-1)
    public UF(int count) {
        this.count = count;
        id = new int[count];
        for (int i = 0; i < count; i++) {
            id[i] = i;
        }
    }

    public void union(int p, int q) {
        int pId = find(p);
        int qId = find(q);
        if (pId == qId) {
            return;
        }
        if (pId != qId) {
            for (int i = 0, n = id.length; i < n; i++) {
                if (id[i] == pId) {
                    id[i] = qId;
                    count--;
                }
            }
        }

    }

    //component identifier for p (0 to N-1)
    public int find(int p) {
        return id[p];
    }

    //return true if p and q are in the same component
    public boolean connected(int p, int q) {
        return find(p) == find(q);
    }

    //number of components
    public int count() {
        return count;
    }
}
