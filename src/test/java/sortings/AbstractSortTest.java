package sortings;

import org.junit.Before;

import java.util.Random;
import java.util.concurrent.ThreadLocalRandom;

public class AbstractSortTest {
    protected Integer[] arr;
    protected Integer[] testArr;

    public final static int NUMB_OF_EL = 10;
    public final static int BOUND = 100;

    @Before
    public void prepareRandomArr() {
        arr = new Integer[NUMB_OF_EL];
        testArr = new Integer[NUMB_OF_EL];

        Random random = ThreadLocalRandom.current();
        for (int i = 0; i < NUMB_OF_EL; i++) {
            Integer randomInt = random.nextInt(BOUND);
            arr[i] = randomInt;
            testArr[i] = randomInt;
        }
    }


}
