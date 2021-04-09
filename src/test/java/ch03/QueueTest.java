package ch03;

import _03DataStructures.Queue;
import _03DataStructures.QueueImpl;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class QueueTest {

    @Test
    public void shouldBeEmpty() {

        Queue<Integer> queue = new QueueImpl<>(Integer.class, 6);
        queue.enqueue(1);
        queue.enqueue(2);
        queue.dequeue();
        queue.dequeue();
        Assertions.assertTrue(queue.isEmpty());
    }

    @Test
    public void assertFIFO() {
        Queue<Integer> queue = new QueueImpl<>(Integer.class, 6);
        queue.enqueue(1);
        queue.enqueue(2);
        queue.enqueue(3);
        Assertions.assertEquals(1, queue.dequeue());
    }

    @Test
    public void assertFIFO2() {
        Queue<Integer> queue = new QueueImpl<>(Integer.class, 6);
        queue.enqueue(1);
        queue.enqueue(2);
        queue.enqueue(3);
        queue.dequeue();
        Assertions.assertEquals(2, queue.dequeue());
    }

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

    public void shouldOverflow() {

    }

    public void shouldUnderflow() {

    }


}
