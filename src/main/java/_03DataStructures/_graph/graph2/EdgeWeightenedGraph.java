package _03DataStructures._graph.graph2;

import java.util.List;
import java.util.Set;

public class EdgeWeightenedGraph {

    private Vertex[] vertices;

    public EdgeWeightenedGraph(int v) {

        this.vertices = new Vertex[v];

        for (int i = 0; i < v; i++) {
            vertices[i] = new Vertex(i);
        }
    }

    public void addEdge(int v, int w, double weight) {

        Edge edge = new Edge(v, w, weight);
        vertices[v].addEdge(edge);
        vertices[w].addEdge(edge);
    }

    public List<Edge> getAdj(int v) {
        return vertices[v].getAdj();
    }

    public Set<Integer> bsf() {
        return null;
    }

    public static void main(String[] args) {

        EdgeWeightenedGraph graph = new EdgeWeightenedGraph(3);

        graph.addEdge(0, 1, 3);
        graph.addEdge(1, 2, 5);
        graph.addEdge(0, 2, 10);
    }
}
