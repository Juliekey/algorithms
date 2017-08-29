package datastruct.linkedlist;

import org.junit.Before;

import java.util.concurrent.ThreadLocalRandom;

public abstract class AbstractTest {
    protected static final int ITERATION_NUMBER = 10;
    int[] testValues = new int[ITERATION_NUMBER];
    @Before
    public void GenerateValues() {
        for (int i = 0; i < ITERATION_NUMBER; i++) {
            Integer randomInt = ThreadLocalRandom.current().nextInt();
            testValues[i] = randomInt;
        }
    }
}
