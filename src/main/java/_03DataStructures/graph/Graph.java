package _03DataStructures.graph;

import java.util.List;

public interface Graph<E> {

    /**
     * number of vertices
     * @return
     */
    int vertices();

    /**
     * ass edge v1-v2 to this graph
     * @param vertex1
     * @param vertex2
     */
    void addEdge(E vertex1, E vertex2, int weight);

    boolean removeEdge(E vertex1, E vertex2);

    boolean addVertex(E vertex);

    boolean removeVertex(E vertex);

    boolean cointains(E vertex);

    boolean isConnected(E v1, E v2);

    List<E> findPath(E v1, E v2);
}
