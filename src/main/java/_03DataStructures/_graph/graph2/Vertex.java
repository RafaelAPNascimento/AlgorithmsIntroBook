package _03DataStructures._graph.graph2;

import java.util.ArrayList;
import java.util.List;

public class Vertex {

    private int id;
    private List<Edge> adjEdgeList  = new ArrayList<>();

    public Vertex(int id) {
        this.id = id;
    }

    public int getId() {
        return id;
    }

    public void addEdge(Edge edge) {
        adjEdgeList.add(edge);
    }

    public List<Edge> getAdj() {
        return adjEdgeList;
    }
}
