package datastruct;

import datastruct.interfaces.QueueInterface;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.util.concurrent.ThreadLocalRandom;

public abstract class AbstractQueueTest extends AbstractTest {
    protected static QueueInterface<Integer> queue;


    @Before
    public void fillQueue() {
        for (int i = 0; i < ITERATION_NUMBER; i++) {
            queue.enqueue(testValues[i]);
        }
    }

    @After
    public void clearQueue() {
        while (!queue.isEmpty()) {
            queue.dequeue();
        }
    }

    @Test
    public void testEnqueue() {
        int queueSize = queue.size();
        int randomInt = ThreadLocalRandom.current().nextInt();
        queue.enqueue(randomInt);
        assert queueSize + 1 == queue.size();
    }

    @Test
    public void testDequeue() {
        Integer queueSize = queue.size();
        for (int i = 0; i < ITERATION_NUMBER; i++) {
            int element = queue.dequeue();
            assert (element == testValues[i]);
            --queueSize;
            assert (queue.size() == queueSize);
        }
    }

    @Test
    public void testIterator() {
        int i = 0;
        for (Integer item : queue) {
            assert item == testValues[i];
            i++;
        }
    }
}
