package _03DataStructures._graph;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class DefaultUndirectedGraphImpl<E> implements Graph<E> {

    private List<E> vertices;
    private List<Edge<E>> edges;

    public DefaultUndirectedGraphImpl() {
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

        public boolean edges(E v1, E v2) {
            return
                v1.equals(vertex1) && v2.equals(vertex2) ||
                    v1.equals(vertex2) && v2.equals(vertex2);
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

        if (edges.contains(edge))
            throw new RuntimeException(String.format("Edge %s to %s already exists", vertex1, vertex2));

        edges.add(edge);
    }

    @Override
    public boolean removeEdge(E vertex1, E vertex2) {

        Edge deleting = new Edge(vertex1, vertex2, 0);
        int index = edges.indexOf(deleting);

        if (index == -1)
            return false;

        deleting = edges.remove(index);

        return deleting != null;
    }

    @Override
    public boolean addVertex(E vertex) {

        if (vertices.contains(vertex))
            return false;

        return vertices.add(vertex);
    }

    @Override
    public boolean removeVertex(E vertex) {

        int index = vertices.indexOf(vertex);
        vertex = vertices.remove(index);

        removeRelatedEdges(vertex);

        return vertex != null;
    }

    private void removeRelatedEdges(E vertex) {

        Set<Edge> deletingEdges = new HashSet<>();
        for (Edge edge : edges) {
            if (edge.vertex1.equals(vertex) || edge.vertex2.equals(vertex))
                deletingEdges.add(edge);
        }
        edges.removeAll(deletingEdges);
    }

    @Override
    public boolean cointains(E vertex) {
        return vertices.contains(vertex);
    }

    @Override
    public boolean isConnected(E v1, E v2) {

        if (!(vertices.contains(v1) || vertices.contains(v2)))
            return false;

        for (Edge<E> edge : edges) {
            if (edge.edges(v1, v2))
                return true;
        }
        return false;
    }

    @Override
    public List<E> findPath(E v1, E v2) {
        return null;
    }
    
}
