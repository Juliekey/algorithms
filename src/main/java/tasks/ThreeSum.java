package tasks;

import search.BinarySearch;

public class ThreeSum {
    public static int count(int[] a) { // Count triples that sum to 0.
        int N = a.length;
        int cnt = 0;
        for (int i = 0; i < N; i++) {
            if (BinarySearch.find(a[i], a) > i) {
                cnt++;
            }
        }
        return cnt;
    }

    public static void main(String[] args) {
        int[] a = ArrayGenerator.genearate(9999999);
        System.out.println(count(a));
    }
}