package datastruct.graphs;

import datastruct.linkedlist.Bag;

import java.io.DataInputStream;
import java.io.IOException;

public class GraphBagImpl extends Graph {
    private Bag<Integer>[] adj;

    @Override
    public void addEdge(int v, int w) {
        adj[v].add(w);
        adj[w].add(v);
        edgesNumb++;
    }

    @Override
    public Iterable<Integer> adj(int v) {
        return adj[v];
    }

    public GraphBagImpl(Integer vNumber) {
        this.verticesNumb = vNumber;
        adj = (Bag<Integer>[]) new Object[vNumber];
        for (int i = 0; i < verticesNumb; i++) {
            adj[i] = new Bag<>();
        }
    }

    public GraphBagImpl(DataInputStream inputStream) throws IOException {
        this(inputStream.readInt());
        edgesNumb = inputStream.readInt();
        for (int i = 0; i < verticesNumb; i++) {
            int v = inputStream.readInt();
            int w = inputStream.readInt();
            addEdge(v, w);
        }
    }

}
