package datastruct.graph2;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class AdjListGraph extends Graph {
    Map<Integer, ArrayList<Integer>> adjListMap = new HashMap<>();

    public void addVertex(int v, int w) {
        numbOfVertices++;
        adjListMap.get(v).add(w);
    }

    public void addEdge() {
        numbOfEdges++;
        adjListMap.put(numbOfEdges, new ArrayList<>());
    }

    @Override
    public List<Integer> getOutNeighbors(int v) {
        return new ArrayList<>(adjListMap.get(v));
    }

}
