package datastruct.graphs;

import datastruct.linkedlist.Stack;

public class Paths {
    private boolean[] marked;
    private int[] edgeTo;
    private final int s;

    public Paths(Graph graph, int s) {
        this.s = s;
        marked = new boolean[graph.verticesNumb];
        edgeTo = new int[graph.verticesNumb];
        dfs(graph, s);
    }

    private void dfs(Graph graph, int s) {
        marked[s] = true;
        for (int w : graph.adj(s))
            if (!marked[w]) {
                edgeTo[w] = s;
                dfs(graph, w);
            }
    }

    public boolean hasPathTo(int v) {
        return marked[v];
    }

    public Stack<Integer> pathTo(int v) {
        if (!hasPathTo(v)) {
            return null;
        }
        Stack<Integer> stack = new Stack<>();
        for (int x = v; x != s; x = edgeTo[v]) {
            stack.push(x);
        }
        stack.push(s);
        return stack;

    }
}
