package sortings;

public class SelectionSort {
    public static void sort(Comparable[] a) {
        int min = 0;
        for (int i = 0, n = a.length; i < n; i++) {
            for (int j = i; j < n; j++) {
                if (less(a[j], a[min])) {
                    min = j;
                }
                swap(a, i, min);
            }
        }
    }

    private static boolean less(Comparable a, Comparable b) {
        return a.compareTo(b) < 0;

    }

    private static void swap(Comparable[] a, int i, int j) {
        Comparable temp = a[j];
        a[j] = a[i];
        a[i] = temp;
    }
}
