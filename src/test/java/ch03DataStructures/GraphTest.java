package ch03DataStructures;

import _03DataStructures.graph.DefaultGraphImpl;
import _03DataStructures.graph.Graph;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class GraphTest {

    @DisplayName("Should throw exception when adding edge before vertices")
    @Test
    public void shouldThrowExceptionWhenAddingEdgeBeforeVertices() {

        Graph<String> graph = new DefaultGraphImpl<>();
        assertThrows(RuntimeException.class, () -> graph.addEdge("A", "B", 2));
    }

    @DisplayName("Should not throw exception when adding edge before vertices")
    @Test
    public void shouldNotThrowExceptionWhenAddingEdgeBeforeVertices() {

        Graph<String> graph = new DefaultGraphImpl<>();
        graph.addVertex("A");
        graph.addVertex("B");
        assertDoesNotThrow(() -> graph.addEdge("A", "B", 8));
    }

    @DisplayName("Should throw exception when adding existing edge")
    @Test
    public void shouldThrowExceptionWhenAddingExistingEdge() {

        Graph<String> graph = new DefaultGraphImpl<>();
        graph.addVertex("A");
        graph.addVertex("B");
        graph.addEdge("A", "B", 8);
        assertThrows(RuntimeException.class, () -> graph.addEdge("A", "B", 8));
    }

    @DisplayName("Should return correct numbers of vertices")
    @Test
    public void shouldReturnCorrectNumberOfVertices() {

        Graph<String> graph = new DefaultGraphImpl<>();

        for (int i = 65; i <= 90; i++) { // A to Z
            String c = String.valueOf((char) i);
            graph.addVertex(c);
        }
        assertEquals(26, graph.vertices(), "Number of vertices is not the expected 26");
    }

    @Test
    public void shouldRemoveEdge() {

        Graph<String> graph = new DefaultGraphImpl<>();
        graph.addVertex("A");
        graph.addVertex("B");
        graph.addEdge("A", "B", 8);
        assertTrue(graph.removeEdge("A", "B"));
    }

    @Test
    public void shouldRemoveVertex() {

        Graph<String> graph = new DefaultGraphImpl<>();
        graph.addVertex("A");
        graph.addVertex("B");
        graph.addVertex("C");
        graph.addEdge("A", "B", 8);

        assertEquals(3, graph.vertices());
        assertTrue(graph.removeVertex("A"));
        assertEquals(2, graph.vertices());
    }

}
