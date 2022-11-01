package _03DataStructures.graph;

import java.util.Iterator;
import java.util.List;

public class GraphImpl<E> implements Graph<E> {

    private int numberOfVertices;
    private int numberOfEdges;

    private List<Vertex> vertices;

    private class Vertex {

        List<Vertex> adj;
        E data;

        public Vertex(E data) {
            this.data = data;
        }

        public void addAdjecent(Vertex e) {
            adj.add(e);
        }
    }

    @Override
    public int vertices() {
        return numberOfEdges;
    }

    @Override
    public int edges() {
        return numberOfEdges;
    }

    @Override
    public void addEdge(E dataVertex1, E dataVertex2) {

        int indexV1 = findIndex(dataVertex1);
        int indexV2 = findIndex(dataVertex2);

        if (indexV1 < 0 || indexV2 < 0)
            throw new RuntimeException("some edge does not exist");

        Vertex v1 = vertices.get(indexV1);
        Vertex v2 = vertices.get(indexV2);

        v1.adj.add(v2);
        v2.adj.add(v1);

        numberOfEdges++;
    }

    // auxilary method to find the index of some vertex containing the data @data
    private int findIndex(E data) {
        throw new  UnsupportedOperationException("not implemented yet");
    }

    @Override
    public Iterator<E> adj(int vertex) {
        return null;
    }

    @Override
    public void removeEdge() {

    }

    @Override
    public boolean cointains(E edge) {
        return false;
    }

    @Override
    public List<E> findPath(E startEdge, E endEdge) {
        return null;
    }
}
