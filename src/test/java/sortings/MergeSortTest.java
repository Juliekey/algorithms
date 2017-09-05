package sortings;


import org.junit.Test;

import java.util.Arrays;


class MergeSortTest extends AbstractSortTest{
    @Test
    void sort() {
        MergeSort.sort(arr);
        Arrays.sort(testArr);
        assert Arrays.deepEquals(arr, testArr);
    }

}