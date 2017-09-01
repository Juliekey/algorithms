package sortings;

public class MergeSort {  //1 2 3 4 5
    private static Comparable[] aux;

    public static void sort(Comparable[] arr) {
        int length = arr.length;
        aux = new Comparable[length];
        sort(arr, 0, length - 1); //5
    }

    private static void sort(Comparable[] arr, int lo, int hi) { //0 5
        if (hi <= lo) {
            return;
        }
        int mid = lo + (hi - lo) / 2; //1
        sort(arr, lo, mid);
        sort(arr, mid + 1, hi);
        //little improvement: don't do recursive calls if array is already sorted
        if (arr[mid] != arr[mid + 1]) {
            merge(arr, lo, mid, hi);
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
