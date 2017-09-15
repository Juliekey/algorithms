package datastruct.graphs;

public class DepthFirstSearch {
    boolean[] marked;
    int count;

    //find vertices connected to a source vertex s
    public DepthFirstSearch(Graph graph, int src) {

        marked = new boolean[graph.getVerticesNumb()];
        dfs(graph, src);
    }

    private void dfs(Graph graph, int src) {
        marked[src] = true;
        count++;
        for (int v :
                graph.adj(src)) {
            if (!marked[v]) {
                dfs(graph, v);
            }
        }
    }

    //is v connected to s?
    public boolean marked(int v) {
        return marked[v];

    }

    //how many vertices are connected to s?
    public int count() {
        return count;
    }
}
