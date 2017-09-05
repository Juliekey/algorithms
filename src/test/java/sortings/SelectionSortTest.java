package sortings;


import org.junit.Test;

import java.util.Arrays;

class SelectionSortTest extends AbstractSortTest {
    @Test
    void sort() {
        SelectionSort.sort(arr);
        Arrays.sort(testArr);
        assert Arrays.deepEquals(arr, testArr);
    }

}