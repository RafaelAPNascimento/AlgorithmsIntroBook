package _03DataStructures.graph;


import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;
import java.util.Set;

public class SimpleUndirectedGraph<E> {

    private Map<E, LinkedList<E>> adj;
    private int V;  // number of vertices
    private int E;  // number of edges

    public SimpleUndirectedGraph(int nodes) {
        this.V = nodes;
        this.E = 0;
        this.adj = new HashMap<>();
    }

    public void addEdge(E v1, E v2) {

        if (!adj.containsKey(v1))
            adj.put(v1, new LinkedList<>());

        if (!adj.containsKey(v2))
            adj.put(v2, new LinkedList<>());

        adj.get(v1).add(v2);
        adj.get(v2).add(v1);
        E++;
    }

    public Set<E> bfs() {

        Set<E> visited = new HashSet<>(V);
        Queue<E> queue = new LinkedList<>();

        visited.add(first());
        queue.offer(first());

        Set<E> result = new HashSet<>();

        while (!queue.isEmpty()) {
            E el = queue.poll();
            result.add(el);
            for (E node : adj.keySet()) {
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

    @Override
    public String toString() {

        StringBuilder sb = new StringBuilder();
        sb.append(V + " vertices, " + E + " edges\n");
        for (int v = 0; v < V; v++) {
            sb.append(v + ": ");
            for (E w : adj.get(v)) {
                sb.append(w + " ");
            }
            sb.append("\n");
        }
        return sb.toString();
    }

    public static void main(String[] args) {
        SimpleUndirectedGraph<Integer> g = new SimpleUndirectedGraph<>(10);
        g.addEdge(0, 1);
        g.addEdge(0, 3);
        g.addEdge(2, 3);
        g.addEdge(2, 4);
        g.addEdge(2, 1);
        g.addEdge(1, 7);
        g.addEdge(2, 6);
        System.out.println(g.bfs());
    }
}
