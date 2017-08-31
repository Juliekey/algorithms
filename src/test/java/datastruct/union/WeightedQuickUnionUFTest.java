package datastruct.union;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Random;
import java.util.concurrent.ThreadLocalRandom;

class WeightedQuickUnionUFTest {
    public static final int ARR_LENGTH = 10;
    public static final int NUMB_OF_TRIES = 10;
    Random random = ThreadLocalRandom.current();
    WeightedQuickUnionUF weightedQuickUnionUF;

    @BeforeEach
    public void createUF() {
        weightedQuickUnionUF = new WeightedQuickUnionUF(ARR_LENGTH);
    }

    @Test
    void union() {
        for (int i = 0; i < NUMB_OF_TRIES; i++) {
            weightedQuickUnionUF.union(random.nextInt(NUMB_OF_TRIES), random.nextInt(NUMB_OF_TRIES));
        }
    }

}