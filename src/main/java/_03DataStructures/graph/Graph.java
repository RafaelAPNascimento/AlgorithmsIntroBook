package _03DataStructures.graph;

import java.util.Set;

public interface Graph<V> {

    void addEdge(V vertex1, V vertex2);

    void addVertex(V vertex);

    Set<V> bfs();

    int size();

    boolean isConnected(V vertex1, V vertex2);
}
