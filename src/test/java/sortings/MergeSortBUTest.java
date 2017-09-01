package sortings;

import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.*;

class MergeSortBUTest extends AbstractSortTest {
    @Test
    void sort() {
        MergeSortBU.sort(arr);
        Arrays.sort(testArr);
        assert Arrays.deepEquals(arr, testArr);
    }

}