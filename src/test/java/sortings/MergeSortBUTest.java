package sortings;


import org.junit.Test;

import java.util.Arrays;


class MergeSortBUTest extends AbstractSortTest {
    @Test
    void sort() {
        MergeSortBU.sort(arr);
        Arrays.sort(testArr);
        assert Arrays.deepEquals(arr, testArr);
    }

}