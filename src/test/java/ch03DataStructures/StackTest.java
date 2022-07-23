package ch03DataStructures;

import _03DataStructures.Stack;
import _03DataStructures.impl.StackImpl;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class StackTest {

    @Test
    public void shouldBeEmptyAtInitialization() {

        Stack<Integer> stack = new StackImpl<>(Integer.class, 6);
        stack.push(1);
        stack.push(2);
        stack.pop();
        stack.pop();
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

    @Test
    public void assertLIFO3() {
        Stack<Integer> stack = new StackImpl<>(Integer.class, 6);
        stack.push(1);
        stack.push(2);
        stack.push(3);
        stack.push(4);
        stack.push(5);
        stack.push(6);
        for (int i = 4; i >= 0; i--)
            stack.pop();

        Assertions.assertEquals(1, stack.pop());
    }

    @Test
    public void assertStackUnderflow() {
        Stack<Integer> stack = new StackImpl<>(Integer.class, 6);
        stack.push(1);
        stack.push(2);
        stack.push(3);
        stack.push(4);
        stack.push(5);
        stack.push(6);
        for (int i = 5; i >= 0; i--)
            stack.pop();

        Assertions.assertThrows(RuntimeException.class, () -> stack.pop());
    }

    @Test
    public void assertStackOverflow() {
        Stack<Integer> stack = new StackImpl<>(Integer.class, 5);
        stack.push(1);
        stack.push(2);
        stack.push(3);
        stack.push(4);
        stack.push(5);

        Assertions.assertThrows(RuntimeException.class, () -> stack.push(6));
    }


}
