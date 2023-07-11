package ch03DataStructures;


import _03DataStructures.Graph;
import _03DataStructures.graph.SimpleUndirectedGraphImpl;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Set;

import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class SimpleUndirectedGraphTest {

    @DisplayName("Should throw exception when adding edge before vertices")
    @Test
    public void shouldThrowExceptionWhenAddingEdgeBeforeVertices() {

        Graph<String> graph = new SimpleUndirectedGraphImpl<>();
        assertThrows(RuntimeException.class, () -> graph.addEdge("A", "B"));
    }

    @DisplayName("Should NOT throw exception when adding edge after vertices")
    @Test
    public void shouldNotThrowExceptionWhenAddingEdgeBeforeVertices() {

        Graph<String> graph = new SimpleUndirectedGraphImpl<>();
        graph.addVertex("A");
        graph.addVertex("B");
        assertDoesNotThrow(() -> graph.addEdge("A", "B"));
    }

    @DisplayName("Should return correct graph size")
    @Test
    public void shouldReturnCorrectGraphSize() {

        Graph<String> graph = new SimpleUndirectedGraphImpl<>();
        graph.addVertex("A");
        graph.addVertex("B");
        graph.addVertex("C");
        graph.addVertex("D");
        int actual = graph.size();
        assertEquals(4, actual);
    }

    @DisplayName("Adding existing edge should be idempotent")
    @Test
    public void shouldBeIdempotentWhenAddingExistingEdge() {

        Graph<String> graph = new SimpleUndirectedGraphImpl<>();
        graph.addVertex("A");
        graph.addVertex("B");
        int expected = graph.size();

        graph.addVertex("A");
        graph.addVertex("B");
        int actual = graph.size();

        assertEquals(expected, actual);
    }

    @DisplayName("Should return correct numbers of vertices")
    @Test
    public void shouldReturnCorrectNumberOfVertices() {

        Graph<String> graph = new SimpleUndirectedGraphImpl<>();

        for (int i = 65; i <= 90; i++) { // A to Z
            String c = String.valueOf((char) i);
            graph.addVertex(c);
        }
        assertEquals(26, graph.size(), "Number of vertices is not the expected 26");
    }

    @Test
    public void shouldBeConnected() {

        Graph<String> graph = new SimpleUndirectedGraphImpl<>();
        graph.addVertex("A");
        graph.addVertex("B");
        graph.addVertex("C");
        graph.addVertex("D");
        graph.addEdge("A", "C");
        assertTrue(graph.isConnected("A", "C"));
    }

    @Test
    public void shouldNotBeConnected() {

        Graph<String> graph = new SimpleUndirectedGraphImpl<>();
        graph.addVertex("A");
        graph.addVertex("B");
        graph.addVertex("C");
        graph.addVertex("D");
        graph.addEdge("A", "C");
        assertFalse(graph.isConnected("A", "B"));
    }

    @Test
    public void shouldTraversalThroughAllConnectedByBFS() {

        SimpleUndirectedGraphImpl<Integer> graph = new SimpleUndirectedGraphImpl<>();
        graph.addVertex(-5);    // not connected
        graph.addVertex(0);
        graph.addVertex(1);
        graph.addVertex(2);
        graph.addVertex(3);
        graph.addVertex(4);
        graph.addVertex(6);
        graph.addVertex(7);
        graph.addVertex(9);     // not connected
        graph.addEdge(0, 1);
        graph.addEdge(0, 3);
        graph.addEdge(2, 3);
        graph.addEdge(2, 4);
        graph.addEdge(2, 1);
        graph.addEdge(1, 7);
        graph.addEdge(2, 6);

        Set<Integer> expected = Set.of(0, 1, 2, 3, 4, 6, 7);
        assertEquals(expected, graph.bfs());
    }
}
