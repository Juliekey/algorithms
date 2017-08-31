package search;

import org.junit.Test;

import java.util.Arrays;

public class BinarySearchTest {
    @Test
    public void testSearchEven() {
        int[] arr = {1, 3, 4, 11};
        Arrays.sort(arr);
        int target = 3;
        assert (arr[1] == target && BinarySearch.find(target, arr) == 1);
    }

    @Test
    public void testSearchOdd() {
        int[] arr = {1, 3, 4, 11, 12};
        int target = 3;
        assert (arr[1] == target && BinarySearch.find(target, arr) == 1);
    }

    @Test
    public void testSearchOneElementArray() {
        int[] arr = {1};
        int target = 1;
        assert (arr[0] == target && BinarySearch.find(target, arr) == 0);
    }


    @Test
    public void testSearchEmpty() {
        int[] arr = {};
        int target = 3;
        assert (BinarySearch.find(target, arr) == -1);
    }

    @Test(expected = NullPointerException.class)
    public void testWithNull() {

        int[] arr = null;
        int target = 3;
        assert (BinarySearch.find(target, arr) == -1);
    }
}
