package ch03;

import _03DataStructures.Stack;
import _03DataStructures.StackImpl;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class StackTest {

    @Test
    public void shouldBeEmptyAtInitialization() {

        Stack<Integer> stack = new StackImpl<>(Integer.class, 6);
        Assertions.assertTrue(stack.isEmpty());
    }

    @Test
    public void assertLIFO() {
        Stack<Integer> stack = new StackImpl<>(Integer.class, 6);
        stack.push(1);
        stack.push(2);
        stack.push(3);
        Assertions.assertEquals(3, stack.pop());
    }

    @Test
    public void assertLIFO2() {
        Stack<Integer> stack = new StackImpl<>(Integer.class, 6);
        stack.push(1);
        stack.push(2);
        stack.push(3);
        stack.pop();
        Assertions.assertEquals(2, stack.pop());
    }
}
