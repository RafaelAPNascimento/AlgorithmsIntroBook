package _03DataStructures.graph;


import _03DataStructures.Graph;

import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;
import java.util.Set;
import java.util.stream.Collectors;

public class SimpleUndirectedGraphImpl<E> implements Graph<E> {

    private Map<E, LinkedList<E>> adj;
    private int edges;  // number of edges

    public SimpleUndirectedGraphImpl() {
        this.edges = 0;
        this.adj = new HashMap<>();
    }

    @Override
    public void addVertex(E vertex) {
        if (!adj.containsKey(vertex))
            adj.put(vertex, new LinkedList<>());
    }

    @Override
    public void addEdge(E v1, E v2) {

        if (!adj.containsKey(v1))
            throw new RuntimeException(String.format("Edge %s doesn't existe", v1));

        if (!adj.containsKey(v2))
            throw new RuntimeException(String.format("Edge %s doesn't existe", v2));

        adj.get(v1).add(v2);
        adj.get(v2).add(v1);
        edges++;
    }

    @Override
    public Set<E> bfs() {

        Set<E> visited = new HashSet<>(adj.size());
        Queue<E> queue = new LinkedList<>();

        visited.add(first());
        queue.offer(first());

        Set<E> result = new HashSet<>();

        while (!queue.isEmpty()) {
            E el = queue.poll();
            result.add(el);
            for (E node : connectedKeySet()) {
                if (!visited.contains(node)) {
                    visited.add(node);
                    queue.offer(node);
                }
            }
        }
        return result;
    }

    private E first() {
        return adj.keySet().iterator().next();
    }

    private Set<E> connectedKeySet() {
        return adj.keySet()
                    .stream()
                    .filter(v -> !adj.get(v).isEmpty())
                    .collect(Collectors.toSet());
    }

    @Override
    public int size() {
        return adj.size();
    }

    @Override
    public boolean isConnected(E vertex1, E vertex2) {

        List<E> vertex1Connections = adj.get(vertex1);
        List<E> vertex2Connections = adj.get(vertex2);

        return vertex1Connections.contains(vertex2);
    }

    @Override
    public String toString() {

        StringBuilder sb = new StringBuilder();
        int V = adj.size();
        sb.append(V + " vertices, " + edges + " edges\n");
        for (int v = 0; v < V; v++) {
            sb.append(v + ": ");
            for (E w : adj.get(v)) {
                sb.append(w + " ");
            }
            sb.append("\n");
        }
        return sb.toString();
    }
}
