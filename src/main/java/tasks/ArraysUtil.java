package tasks;

import java.util.Random;
import java.util.concurrent.ThreadLocalRandom;

public class ArraysUtil {
    //Fisher–Yates shuffle
    public static void shuffle(Comparable[] arr) {
        Random random = ThreadLocalRandom.current();
        for (int i = arr.length - 1; i > 0; i--) {
            int randomIndex = random.nextInt(i + 1);
            swap(arr, i, randomIndex);
        }
    }

    public static void swap(Comparable[] arr, int i, int j) {
        Comparable temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }
}
