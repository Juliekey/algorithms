package sortings;


import tasks.ArraysUtil;

public class InsertionSort {
    public static void sort(Comparable[] arr) {
        for (int i = 1, n = arr.length; i < n; i++) {
            for (int j = i; j > 0; j--) {
                if (arr[j].compareTo(arr[j - 1]) < 0) {
                    ArraysUtil.swap(arr, j, j - 1);
                }
            }
        }
    }


    public static void sort(Comparable[] arr, int lo, int hi) {
        for (int i = lo + 1; i < hi; i++) {
            for (int j = i; j > lo; j--) {
                if (arr[j].compareTo(arr[j - 1]) < 0) {
                    ArraysUtil.swap(arr, j, j - 1);
                }
            }
        }
    }
}
