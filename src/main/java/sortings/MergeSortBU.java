package sortings;

public class MergeSortBU {  //2 3 4 2 5 1
    private static Comparable[] aux;

    public static void sort(Comparable[] arr) {
        int length = arr.length;
        aux = new Comparable[length];
        for (int size = 1; size < length; size = 2 * size) {
            for (int j = 0; j < length - size; j += size * 2) {
                System.out.println("size: " + size + " (lo: " + j + " mid: " + (j + size - 1) + " hi:" + Math.min(j + size + size - 1, length - 1) + ")");
                merge(arr, j, j + size - 1, Math.min(j + size + size - 1, length - 1));
            }
        }
    }

    protected static void merge(Comparable[] arr, int lo, int mid, int hi) {
        int left = lo;
        int right = mid + 1; //3
        for (int i = lo; i <= hi; i++) {
            aux[i] = arr[i];
        }
        for (int i = lo; i <= hi; i++) {
            //left part exhausted
            if (left > mid) {
                arr[i] = aux[right++];
            }
            //right part exhausted
            else if (right > hi) {
                arr[i] = aux[left++];
            }
            //left part element less than right part element
            else if (aux[left].compareTo(aux[right]) < 0) {
                arr[i] = aux[left++];
            }
            //right part element less than left part element
            else {
                arr[i] = aux[right++];
            }
        }
    }


}
