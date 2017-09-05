package datastruct.arrays;


import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.util.Arrays;
import java.util.Random;
import java.util.concurrent.ThreadLocalRandom;

public class MaxPqHeapTest {
    private static final int MAX_CAPACITY = 50;
    private static final int NUMB_OF_EL = 10;
    private static final int RANGE = 20;

    MaxPqHeap<Integer> maxPqHeap = new MaxPqHeap<>(MAX_CAPACITY);
    int[] arr = new int[MAX_CAPACITY];

    Random random = ThreadLocalRandom.current();

    @Before
    public void init() {
        for (int i = 0; i < NUMB_OF_EL; i++) {
            int randomInt = random.nextInt(RANGE);
            arr[i] = randomInt;
            maxPqHeap.add(randomInt);
        }
    }

    @After
    public void destroy() {
        while (!maxPqHeap.isEmpty()) {
            maxPqHeap.removeMax();
        }
        arr = new int[MAX_CAPACITY];
    }

    @Test
    public void add() {
        int currSize = maxPqHeap.size();
        maxPqHeap.add(random.nextInt());
        assert currSize + 1 == maxPqHeap.size();
    }

    @Test
    public void removeMax() {
        int max = Arrays.stream(arr).max().getAsInt();
        int currSize = maxPqHeap.size();
        int removedMax = maxPqHeap.removeMax();
        assert max == removedMax;
        assert currSize - 1 == maxPqHeap.size();
    }


}