package ch03DataStructures;

import _03DataStructures._graph.DefaultUndirectedGraphImpl;
import _03DataStructures._graph.Graph;
import _03DataStructures._graph.UndirectedGraph;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class GraphTest {

    @DisplayName("Should throw exception when adding edge before vertices")
    @Test
    public void shouldThrowExceptionWhenAddingEdgeBeforeVertices() {

        UndirectedGraph<String> graph = new UndirectedGraph<>();
        assertThrows(RuntimeException.class, () -> graph.addEdge("A", "B", 2));
    }

    @DisplayName("Should not throw exception when adding edge after vertices")
    @Test
    public void shouldNotThrowExceptionWhenAddingEdgeBeforeVertices() {

        Graph<String> graph = new DefaultUndirectedGraphImpl<>();
        graph.addVertex("A");
        graph.addVertex("B");
        assertDoesNotThrow(() -> graph.addEdge("A", "B", 8));
    }

    @DisplayName("Should throw exception when adding existing edge")
    @Test
    public void shouldThrowExceptionWhenAddingExistingEdge() {

        Graph<String> graph = new DefaultUndirectedGraphImpl<>();
        graph.addVertex("A");
        graph.addVertex("B");
        graph.addEdge("A", "B", 8);
        assertThrows(RuntimeException.class, () -> graph.addEdge("A", "B", 8));
    }

    @DisplayName("Should return correct numbers of vertices")
    @Test
    public void shouldReturnCorrectNumberOfVertices() {

        Graph<String> graph = new DefaultUndirectedGraphImpl<>();

        for (int i = 65; i <= 90; i++) { // A to Z
            String c = String.valueOf((char) i);
            graph.addVertex(c);
        }
        assertEquals(26, graph.vertices(), "Number of vertices is not the expected 26");
    }

    @Test
    public void shouldRemoveEdge() {

        Graph<String> graph = new DefaultUndirectedGraphImpl<>();
        graph.addVertex("A");
        graph.addVertex("B");
        graph.addEdge("A", "B", 8);
        assertTrue(graph.removeEdge("A", "B"));
    }

    @Test
    public void shouldNotRemoveEdge() {

        Graph<String> graph = new DefaultUndirectedGraphImpl<>();
        graph.addVertex("A");
        graph.addVertex("B");
        graph.addEdge("A", "B", 8);
        assertFalse(graph.removeEdge("A", "C"));
    }

    @Test
    public void shouldRemoveVertex() {

        Graph<String> graph = new DefaultUndirectedGraphImpl<>();
        graph.addVertex("A");
        graph.addVertex("B");
        graph.addVertex("C");
        graph.addEdge("A", "B", 8);

        assertEquals(3, graph.vertices());
        assertTrue(graph.removeVertex("A"));
        assertEquals(2, graph.vertices());
    }

    @Test
    public void shouldBeConnected() {

        Graph<String> graph = new DefaultUndirectedGraphImpl<>();
        graph.addVertex("M");
        graph.addVertex("N");
        graph.addVertex("O");
        graph.addVertex("P");

        graph.addEdge("M", "O", 5);
        assertTrue(graph.isConnected("M", "O"));
    }

    @Test
    public void shouldNotBeConnected() {

        Graph<String> graph = new DefaultUndirectedGraphImpl<>();
        graph.addVertex("M");
        graph.addVertex("N");
        graph.addVertex("O");
        graph.addVertex("P");

        graph.addEdge("M", "O", 5);
        graph.removeVertex("O");
        assertFalse(graph.isConnected("M", "O"));
    }
}
