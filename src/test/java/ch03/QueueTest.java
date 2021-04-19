package ch03;

import _03DataStructures.Queue;
import _03DataStructures.QueueImpl;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class QueueTest {

    @DisplayName("Queue should be empty at initialization")
    @Test
    public void shouldBeEmptyAtInitialization() {

        Queue<String> queue = new QueueImpl<>(String.class, 50);
        Assertions.assertTrue(queue.isEmpty());
    }

    @DisplayName("Should be empty after dequeuing all elements")
    @Test
    public void shouldBeEmpty() {

        Queue<Integer> queue = new QueueImpl<>(Integer.class, 6);
        queue.enqueue(1);
        queue.enqueue(2);
        queue.dequeue();
        queue.dequeue();
        Assertions.assertTrue(queue.isEmpty());
    }

    @DisplayName("Should dequeue the correct element")
    @Test
    public void assertFIFO() {
        Queue<Integer> queue = new QueueImpl<>(Integer.class, 6);
        queue.enqueue(1);
        queue.enqueue(2);
        queue.enqueue(3);
        Assertions.assertEquals(1, queue.dequeue());
    }

    @DisplayName("Should dequeue correct element")
    @Test
    public void assertFIFO2() {
        Queue<Integer> queue = new QueueImpl<>(Integer.class, 6);
        queue.enqueue(1);
        queue.enqueue(2);
        queue.enqueue(3);
        queue.dequeue();
        Assertions.assertEquals(2, queue.dequeue());
    }

    @DisplayName("Should dequeue correct element")
    @Test
    public void assertFIFO3() {
        Queue<Integer> queue = new QueueImpl<>(Integer.class, 6);
        queue.enqueue(1);
        queue.enqueue(2);
        queue.enqueue(3);
        queue.enqueue(4);
        queue.enqueue(5);
        queue.enqueue(6);
        for (int i = 4; i >= 0; i--)
            queue.dequeue();

        Assertions.assertEquals(6, queue.dequeue());
    }

    @Test
    public void shouldOverflow() {

        Queue<Integer> queue = new QueueImpl<>(Integer.class, 4);
        queue.enqueue(1);
        queue.enqueue(2);
        queue.enqueue(3);
        queue.enqueue(4);
        Assertions.assertThrows(RuntimeException.class, () -> queue.enqueue(1));
    }

    @Test
    public void shouldUnderflow() {

        Queue<Integer> queue = new QueueImpl<>(Integer.class, 4);
        queue.enqueue(1);
        queue.enqueue(2);
        queue.enqueue(3);
        queue.enqueue(4);
        queue.dequeue();
        queue.dequeue();
        queue.dequeue();
        queue.dequeue();
        Assertions.assertThrows(RuntimeException.class, () -> queue.dequeue());
    }
}
