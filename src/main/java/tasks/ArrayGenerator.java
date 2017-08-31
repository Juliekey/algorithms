package tasks;

import java.util.Random;
import java.util.concurrent.ThreadLocalRandom;

public class ArrayGenerator {
    public static int[] genearate(int length) {
        int[] arr = new int[length];
        Random random = ThreadLocalRandom.current();
        for (int i = 0; i < length; i++) {
            arr[i] = random.nextInt();
        }
        return arr;
    }
}
