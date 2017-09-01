package sortings;

import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.Objects;

class SelectionSortTest extends AbstractSortTest {
    @Test
    void sort() {
        SelectionSort.sort(arr);
        Arrays.sort(testArr);
        assert Arrays.deepEquals(arr, testArr);
    }

}