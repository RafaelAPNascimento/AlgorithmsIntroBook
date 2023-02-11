package _03DataStructures.graph;

import java.util.ArrayList;
import java.util.List;

public class GraphImpl<E> implements Graph<E> {

    private List<E> vertices;
    private List<Edge<E>> edges;

    public GraphImpl() {
        vertices = new ArrayList<>();
        edges = new ArrayList<>();
    }

    private class Edge<E> {
        E vertex1;
        E vertex2;
        int weight;

        Edge(E vertex1, E vertex2, int weight) {
            this.vertex1 = vertex1;
            this.vertex2 = vertex2;
            this.weight = weight;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;

            Edge<?> edge = (Edge<?>) o;

            if (!vertex1.equals(edge.vertex1)) return false;
            return vertex2.equals(edge.vertex2);
        }

        @Override
        public int hashCode() {
            int result = vertex1.hashCode();
            result = 31 * result + vertex2.hashCode();
            return result;
        }
    }

    @Override
    public int vertices() {
        return vertices.size();
    }

    @Override
    public void addEdge(E vertex1, E vertex2, int weight) {

        if (!vertices.contains(vertex1) || !vertices.contains(vertex2))
            throw new RuntimeException("Some vertex is not part of the graph yet");

        Edge edge = new Edge(vertex1, vertex2, weight);
        edges.add(edge);        // what if we add a already existing edge?
    }

    @Override
    public boolean removeEdge(E vertex1, E vertex2) {

        Edge deleting = new Edge(vertex1, vertex2, 0);
        int index = edges.indexOf(deleting);
        deleting = edges.remove(index);
        return deleting != null;
    }

    @Override
    public boolean addVertex(E vertex) {
        // I want unique vertices!
        return vertices.add(vertex);
    }

    @Override
    public boolean removeVertex(E vertex) {

        int index = vertices.indexOf(vertex);
        vertex = vertices.remove(index);
        return vertex != null;
    }

    @Override
    public boolean cointains(E vertex) {
        return vertices.contains(vertex);
    }

    @Override
    public List<E> findPath(E startEdge, E endEdge) {
        return null;
    }
}
