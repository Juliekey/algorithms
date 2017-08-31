package datastruct.linkedlist;

import datastruct.AbstractQueueTest;
import org.junit.BeforeClass;

public class LinkedListQueueTest extends AbstractQueueTest {

    @BeforeClass
    public static void createQueue() {
        queue = new LinkedListQueue<>();
    }


}
