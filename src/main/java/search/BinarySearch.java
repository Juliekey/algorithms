package search;

import com.sun.istack.internal.NotNull;

public class BinarySearch {
    public static int find(int target, @NotNull int[] sortedArr) {
        int lo = 0;
        int hi = sortedArr.length - 1;
        while (lo <= hi) {
            int mid = lo + (hi - lo) / 2;
            if (sortedArr[mid] < target) {
                lo++;
            } else if (sortedArr[mid] > target) {
                hi--;
            } else {
                return mid;
            }
        }
        return -1;
    }
}
