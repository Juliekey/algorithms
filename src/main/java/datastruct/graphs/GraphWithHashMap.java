package datastruct.graphs;

import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;

public class GraphWithHashMap {
    private HashMap<Integer, Node> nodeLookUp = new HashMap<>();

    public GraphWithHashMap(Integer vNumber) {
        for (int i = 0; i < vNumber; i++) {
            nodeLookUp.put(i, new Node(i));
        }
    }

    private class Node {
        private int id;
        LinkedList<Node> adjacent = new LinkedList();

        private Node(int id) {
            this.id = id;
        }
    }

    private Node getNode(int id) {
        return nodeLookUp.get(id);
    }

    public void addEdge(int source, int destination) {
        Node s = getNode(source);
        Node d = getNode(destination);
        s.adjacent.add(d);
    }

    public boolean hasPathDFS(int source, int destination) {
        Node sourceNode = getNode(source);
        Node destinationNode = getNode(destination);
        HashSet<Integer> visited = new HashSet<>();
        return hasPathDFS(sourceNode, destinationNode, visited);
    }

    private boolean hasPathDFS(Node source, Node destination, HashSet<Integer> visited) {
        if (visited.contains(source)) {
            return false;
        }
        visited.add(source.id);
        if (source == destination) {
            return true;
        }
        for (Node child :
                source.adjacent) {
            if (hasPathDFS(child, destination, visited)) {
                return true;
            }
        }
        return false;
    }

    public boolean hasPathBFS(int source, int destination) {
        Node sourceNode = getNode(source);
        HashSet<Integer> visited = new HashSet<>();
        LinkedList<Node> nextToVisit = new LinkedList<>();
        nextToVisit.add(sourceNode);
        while (!nextToVisit.isEmpty()) {
            Node node = nextToVisit.remove();
            if (node.id == destination) {
                return true;
            }
            if (visited.contains(node.id)) {
                continue;
            }
            visited.add(node.id);
            for (Node child : node.adjacent) {
                nextToVisit.add(child);
            }
        }
        return false;
    }
}
