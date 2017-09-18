package datastruct.graph2;

import java.util.ArrayList;
import java.util.List;

public class AdjMatrixGraph extends Graph {
    private int[][] adjMatrix;

    @Override
    public void addVertex(int v, int w) {

    }

    @Override
    public void addEdge() {

    }

    @Override
    public List<Integer> getOutNeighbors(int v) {
        List<Integer> neighbors = new ArrayList<>();
        for (int i = 0; i < numbOfVertices; i++) {
            if (adjMatrix[v][i] != 0) {
                neighbors.add(i);
            }
        }
        return neighbors;
    }
}
