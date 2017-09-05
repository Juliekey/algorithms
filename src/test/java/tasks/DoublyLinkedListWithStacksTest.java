package tasks;



import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.util.LinkedList;
import java.util.List;
import java.util.Random;
import java.util.concurrent.ThreadLocalRandom;

class DoublyLinkedListWithStacksTest {
    DoublyLinkedListWithStacks<Integer> list = new DoublyLinkedListWithStacks<>();
    List<Integer> testData = new LinkedList<>();
    public final static int NUMB_OF_ELEMENTS = 5;
    public final static Random random = ThreadLocalRandom.current();

    @Before
    public void setUp() {
        for (int i = 0; i < NUMB_OF_ELEMENTS; i++) {
            Integer randomInt = random.nextInt();
            list.addLast(randomInt);
            testData.add(randomInt);
        }

    }

    @After
    public void tearDown() {
        list = new DoublyLinkedListWithStacks<>();
    }

    @Test
    void addFirst() {
        int size = list.size();
        Integer randomInt = random.nextInt();
        list.addFirst(randomInt);
        int newSize = list.size();
        assert size + 1 == newSize;
        int cnt = 0;
        for (Integer element :
                list) {
            if (cnt == 0) {
                assert element.equals(randomInt);
                System.out.println("Add First Works");
                break;
            }
        }
    }

    @Test
    void addLast() {
        int size = list.size();
        Integer randomInt = random.nextInt();
        list.addLast(randomInt);
        int cnt = 0;
        int newSize = list.size();
        assert size + 1 == newSize;
        for (Integer element :
                list) {
            if (cnt == newSize - 1) {
                assert element.equals(randomInt);
                System.out.println("Add Last Works");
            }
            cnt++;
        }
    }

    @Test
    void removeFirst() {
        Integer randomInt = random.nextInt();

        list.addFirst(randomInt);
        int size = list.size();

        Integer removed = list.removeFirst();

        assert size - 1 == list.size();
        assert randomInt.equals(removed);
    }

    @Test
    void removeLast() {
        Integer randomInt = random.nextInt();

        list.addLast(randomInt);
        int size = list.size();

        Integer removed = list.removeLast();

        assert size - 1 == list.size();
        assert randomInt.equals(removed);
    }

    @Test
    void remove() {
        Integer randomInt = random.nextInt();

        list.addLast(randomInt);
        testData.add(randomInt);

        int size = list.size();

        list.remove(randomInt);
        testData.remove(randomInt);

        assert size - 1 == list.size();
        iterator();
    }

    @Test
    void size() {
        assert list.size() == testData.size();
    }

    @Test
    void iterator() {
        final Object[] objects = testData.toArray();
        for (int i = 0; i < 5; i++) {
            int cnt = 0;
            for (Integer el :
                    list) {
                assert el.equals(objects[cnt]);
                cnt++;
                System.out.println(el);
            }
        }
    }

}