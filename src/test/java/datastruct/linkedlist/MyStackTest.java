package datastruct.linkedlist;


import org.junit.Before;
import org.junit.Test;

import java.util.concurrent.ThreadLocalRandom;

public class MyStackTest extends AbstractTest {
    //    protected static final int ITERATION_NUMBER = 10;
//    int[] testValues = new int[ITERATION_NUMBER];
//
    private Stack<Integer> stack = new Stack<>();

//    @Before
//    public void GenerateValues() {
//        for (int i = 0; i < ITERATION_NUMBER; i++) {
//            Integer randomInt = ThreadLocalRandom.current().nextInt();
//            stack.push(randomInt);
//            testValues[i] = randomInt;
//        }
//    }

    @Before
    public void fillStack() {
        for (int i = 0; i < ITERATION_NUMBER; i++) {
            stack.push(testValues[i]);
        }
    }

    @Test
    public void testPush() {
        int stackSize = stack.size();
        Integer randomInt = ThreadLocalRandom.current().nextInt();
        stack.push(randomInt);
        assert stackSize + 1 == stack.size();
    }

    @Test
    public void testPop() {
        Integer stackSize = stack.size();
        for (int i = 0, j = ITERATION_NUMBER - 1; i < ITERATION_NUMBER; i++, j--) {
            int element = stack.pop();
            assert (element == testValues[j]);
            --stackSize;
            assert (stack.size() == stackSize);
        }
    }

}
