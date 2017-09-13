package datastruct.graphs;

public abstract class Graph {
    protected int verticesNumb;
    protected int edgesNumb;

    public int getVerticesNumb() {
        return verticesNumb;
    }

    public int getEdgesNumb() {
        return edgesNumb;
    }

    public abstract void addEdge(int v, int w);

    //vertices adjacent to v
    public abstract Iterable<Integer> adj(int v);

    @Override
    public String toString() {
        String s = verticesNumb + " vertices, " + edgesNumb + " edges";
        for (int v = 0; v < verticesNumb; v++) {
            s += v + ": ";
            for (int w : this.adj(v)) {
                s += w + " ";
            }
            s += "\n";
        }
        return s;
    }

}
