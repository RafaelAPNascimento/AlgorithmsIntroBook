package _03DataStructures.graph.graph2;

import java.util.ArrayList;
import java.util.List;

public class Vertex<E> {

    private E data;
    private boolean visited;
    private List<Vertex> adjacencyList;

    public Vertex(E data) {
        this.data = data;
        this.adjacencyList = new ArrayList<>();
    }

    public E getData() {
        return data;
    }

    public void setData(E data) {
        this.data = data;
    }

    public boolean isVisited() {
        return visited;
    }

    public void setVisited(boolean visited) {
        this.visited = visited;
    }

    public List<Vertex> getAdjacencyList() {
        return adjacencyList;
    }

    public void addNeighbor(Vertex vertex) {
        adjacencyList.add(vertex);
        vertex.adjacencyList.add(this);     // undirected graph
    }

    @Override
    public String toString() {
        return data.toString();
    }
}
