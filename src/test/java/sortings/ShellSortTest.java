package sortings;


import org.junit.Test;

import java.util.Arrays;

class ShellSortTest extends AbstractSortTest {
    @Test
    void sort() {
        ShellSort.sort(arr);
        Arrays.sort(testArr);
        assert Arrays.deepEquals(arr, testArr);
    }

}