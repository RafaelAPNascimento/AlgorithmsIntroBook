package ch02;

import _02SortingAndOrderStatistics.heapSort.MaxHeap;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;

@TestInstance(TestInstance.Lifecycle.PER_CLASS)
public class MaxHeapTest {

    @Test
    @DisplayName("Should throws NullPointerException when passing null to constructor")
    public void shouldThrowNullPointerExceptionWhenPassingNullInConstructor() {

        Assertions.assertThrows(NullPointerException.class, () -> {
            new MaxHeap(null);
        });
    }
}
