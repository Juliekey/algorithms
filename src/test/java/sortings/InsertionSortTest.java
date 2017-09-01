package sortings;

import org.junit.jupiter.api.Test;

import java.util.Arrays;

class InsertionSortTest extends AbstractSortTest {
    @Test
    void sort() {
        InsertionSort.sort(arr);
        Arrays.sort(testArr);
        assert Arrays.deepEquals(arr, testArr);
    }
}