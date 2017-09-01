package sortings;

import tasks.ArraysUtil;

public class ShellSort {
    public static void sort(Comparable[] arr) {
        int arrLen = arr.length;
        int gap = 1;
        while (gap < arrLen / 3) {
            gap = gap * 3 + 1;
        }
        while (gap >= 1) {
            for (int i = gap; i < arrLen; i++) {
                for (int j = i; j >= gap; j -= gap) {
                    if (arr[j].compareTo(arr[j - gap]) < 0) {
                        ArraysUtil.swap(arr, j, j - gap);
                    }
                }
            }
            gap /= 3;
        }
    }


}


