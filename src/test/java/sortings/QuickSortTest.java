package sortings;


import org.junit.Test;

import java.util.Arrays;

class QuickSortTest extends AbstractSortTest {
    @Test
    void sort() {
        QuickSort.sort(arr);
        Arrays.sort(testArr);
        assert Arrays.deepEquals(arr, testArr);
    }

}