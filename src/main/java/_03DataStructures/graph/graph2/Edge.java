package _03DataStructures.graph.graph2;

public class Edge {

    private Vertex startVertex;
    private Vertex endVertex;
    private int weight;

    public <E> Edge(Vertex<E> startVertex, Vertex<E> endVertex, int weight) {
        this.startVertex = startVertex;
        this.endVertex = endVertex;
        this.weight = weight;
    }

    public <E> Vertex<E> getStartVertex() {
        return startVertex;
    }

    public <E> void setStartVertex(Vertex<E> startVertex) {
        this.startVertex = startVertex;
    }

    public <E> Vertex<E> getEndVertex() {
        return endVertex;
    }

    public <E> void setEndVertex(Vertex<E> endVertex) {
        this.endVertex = endVertex;
    }

    public int getWeight() {
        return weight;
    }

    public void setWeight(int weight) {
        this.weight = weight;
    }
}
