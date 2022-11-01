package _03DataStructures.graph;

import java.util.Iterator;
import java.util.List;

public interface Graph<E> {

    /**
     * number of vertices
     * @return
     */
    int vertices();

    /**
     * number of edges
     * @return
     */
    int edges();

    /**
     * ass edge v1-v2 to this graph
     * @param vertex1
     * @param vertex2
     */
    void addEdge(E vertex1, E vertex2);

    /**
     * vertices adjecent to vertex
     * @param vertex
     * @return
     */
    Iterator<E> adj(int vertex);

    void removeEdge();

    boolean cointains(E edge);

    List<E> findPath(E startEdge, E endEdge);
}
