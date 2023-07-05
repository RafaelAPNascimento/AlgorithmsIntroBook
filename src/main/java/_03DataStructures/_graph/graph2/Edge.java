package _03DataStructures._graph.graph2;

public class Edge {

    private int v, w;
    private double weight;

    public Edge(int v, int w, double weight) {
        this.v = v;
        this.w = w;
        this.weight = weight;
    }

    @Override
    public String toString() {
        return "{"
                + "\"v\":\"" + v + "\""
                + ", \"w\":\"" + w + "\""
                + ", \"weight\":\"" + weight + "\""
                + "}";
    }
}
