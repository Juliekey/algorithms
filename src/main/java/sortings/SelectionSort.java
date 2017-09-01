package sortings;

import tasks.ArraysUtil;

public class SelectionSort {
    public static void sort(Comparable[] a) {
        int min = 0;
        for (int i = 0, n = a.length; i < n; i++) {
            min = i;
            for (int j = i; j < n; j++) {
                if (less(a[j], a[min])) {
                    min = j;
                }
            }
            ArraysUtil.swap(a, i, min);
        }
    }

    private static boolean less(Comparable a, Comparable b) {
        return a.compareTo(b) < 0;

    }


}
