package _03DataStructures.graph.graph2;

import java.util.ArrayList;
import java.util.List;

public class Graph<V> {

    private List<Vertex<V>> vertices;
    private List<Edge> edges;

    private int countVertices = 0;

    public Graph() {
        vertices = new ArrayList<>();
        edges = new ArrayList<>();
    }

    public void addEdge(V v1, V v2, int weight) {

        boolean containsV1 = contains(v1);
        boolean containsV2 = contains(v2);

        if (containsV1 && containsV2) {
            //updateWeight(v1, v2, weight);
        }
        else if (containsV1) {
            //link(v1, v2, weight);
        }
        else if (containsV2) {
            //link(v2, v1, weight);
        }
        else {
            //addNewEdge(v1, v2, edge);
        }
    }

    public void removeEdge(Vertex<V> v1, Vertex<V> v2) {

    }

    public void addVertex(Vertex<V> vertex) {

    }

    public int adjecencies(Vertex<V> vertex) {
        return 0;
    }

    public int countVertices() {
        return 0;
    }

    public boolean contains(V vertex) {
        return false;
    }
}
