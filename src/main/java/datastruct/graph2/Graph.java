package datastruct.graph2;

import java.util.List;

public abstract class Graph {
    protected int numbOfEdges;
    protected int numbOfVertices;

    public abstract void addVertex(int v, int w);

    public abstract void addEdge();

    public abstract List<Integer> getOutNeighbors(int v);
}
