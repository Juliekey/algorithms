package sortings;
//TODO
public class ShellSort {
    public static void sort(Comparable[] arr) {
        int arrLen = arr.length;
        int gap = 1;
        while (gap < arrLen / 3) {
            gap = gap * 3 + 1;
        }
        for (int i = 1; i < arrLen; i++) {
            for (int j = i; j > gap ; j++) {

            }
        }
    }

    private static void swap(Comparable[] a, int i, int j) {
        Comparable temp = a[j];
        a[j] = a[i];
        a[i] = temp;
    }
}
