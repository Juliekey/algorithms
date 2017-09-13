package datastruct.graphs;

public class Search {
    Graph graph;
    int src;

    //find vertices connected to a source vertex s
    public Search(Graph graph, int src) {
        this.graph = graph;
        this.src = src;
    }

    //is v connected to s?
    public boolean marked(int v) {
        return false;

    }

    //how many vertices are connected to s?
    public int count() {
        return -1;
    }
}
