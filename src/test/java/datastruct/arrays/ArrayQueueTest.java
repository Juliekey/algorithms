package datastruct.arrays;

import datastruct.AbstractQueueTest;
import org.junit.BeforeClass;

public class ArrayQueueTest extends AbstractQueueTest {
    @BeforeClass
    public static void createQueue() {
        queue = new ArrayQueue<>();
    }

}
