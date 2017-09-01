package sortings;

import tasks.ArraysUtil;

public class ImprovedQuickSort {
    public static final int SMALL_ARR_SIZE = 10;

    public static void sort(Comparable[] arr) {
        ArraysUtil.shuffle(arr);
        sort(arr, 0, arr.length - 1);
    }

    private static void sort(Comparable[] arr, int lo, int hi) {
        //Improvement - using insertion sort for tiny arrays
        if (hi <= lo + SMALL_ARR_SIZE) {
            InsertionSort.sort(arr, lo, hi);
            return;
        }
        int j = partition(arr, lo, hi);
        sort(arr, lo, j - 1);
        sort(arr, j + 1, hi);
    }

    private static int partition(Comparable[] arr, int lo, int hi) {
        int left = lo;
        int right = hi + 1;
        Comparable pivot = arr[lo];
        while (true) {
            while (arr[++left].compareTo(pivot) < 0) {
                if (left == hi) {
                    break;
                }
            }
            while (pivot.compareTo(arr[--right]) < 0) {
                if (right == lo) {
                    break;
                }
            }
            if (right <= left) {
                break;
            }
            ArraysUtil.swap(arr, left, right);
        }
        //right - is a first from right index of element that is smaller than pivot
        ArraysUtil.swap(arr, lo, right);
        return right;
    }

}
