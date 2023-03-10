package _03DataStructures.graph;


import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Set;

public class SimpleGraphImpl {

    private LinkedList<Integer>[] adj;
    private int V;  // number of vertices
    private int E;  // number of edges

    public SimpleGraphImpl(int nodes) {
        this.V = nodes;
        this.E = 0;
        this.adj = new LinkedList[nodes];
        for (int i = 0; i < nodes; i++) {
            adj[i] = new java.util.LinkedList<>();
        }
    }

    public void addEdge(int u, int v) {
        adj[u].add(v);
        adj[v].add(u);
        E++;
    }

    public Set<Integer> bfs() {
        boolean[] visited = new boolean[V];
        Queue<Integer> queue = new LinkedList<>();
        visited[0] = true;
        queue.offer(0);

        Set<Integer> result = new HashSet<>();

        while (!queue.isEmpty()) {
            Integer el = queue.poll();
            result.add(el);
            for (Integer node : adj[el]) {
                if (!visited[node]) {
                    visited[node] = true;
                    queue.offer(node);
                }
            }
        }
        return result;
    }

    @Override
    public String toString() {

        StringBuilder sb = new StringBuilder();
        sb.append(V + " vertices, " + E + " edges\n");
        for (int v = 0; v < V; v++) {
            sb.append(v + ": ");
            for (int w : adj[v]) {
                sb.append(w + " ");
            }
            sb.append("\n");
        }
        return sb.toString();
    }

    public static void main(String[] args) {
        SimpleGraphImpl g = new SimpleGraphImpl(8);
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
