package datastruct.linkedlist;


import org.junit.After;
import org.junit.Before;
import org.junit.Test;


import java.util.concurrent.ThreadLocalRandom;

public class DoublyLinkedListTest {
    DoublyLinkedList<Integer> list = new DoublyLinkedList<>();
    ThreadLocalRandom random = ThreadLocalRandom.current();
    public static final int NUMB_OF_ELEMENTS = 20;

    @Before
    public void setUp() {
        for (int i = 0; i < NUMB_OF_ELEMENTS; i++) {
            list.insertAtBeginning(random.nextInt());
        }

    }

    @After
    public void tearDown() {
        list = new DoublyLinkedList<>();
    }

    @Test
    public void insertAtBeginning() {
        Integer size = list.size();
        int randomInt = random.nextInt();
        list.insertAtBeginning(randomInt);
        assert size + 1 == list.size();
        assert list.removeFirstOccurrence(randomInt);

    }

    @Test
    public void insertAtEnd() {
        Integer size = list.size();
        int randomInt = random.nextInt();
        list.insertAtEnd(randomInt);
        assert size + 1 == list.size();
        assert list.removeFirstOccurrence(randomInt);
    }

    @Test
    public void removeFromTheBeginning() {
        Integer size = list.size();
        list.removeFromTheBeginning();
        assert size - 1 == list.size();
    }

    @Test
    public void removeFromEnd() {
        Integer size = list.size();
        list.removeFromTheEnd();
        assert size - 1 == list.size();
    }

    @Test
    public void insertBefore() {
        //inserting before first
        int firstInt = random.nextInt();
        list.insertAtBeginning(firstInt);
        int intToInsert1 = random.nextInt();
        list.insertBefore(firstInt, intToInsert1);

        //inserting before last
        int lastInt = random.nextInt();
        list.insertAtEnd(lastInt);
        int intToInsert2 = random.nextInt();
        list.insertBefore(lastInt, intToInsert2);

        //inserting at any position
        int intToInsert3 = random.nextInt();
        list.insertBefore(firstInt, intToInsert3);


    }

    @Test
    public void insertAfter() {
        //inserting after first
        int firstInt = random.nextInt();
        list.insertAtBeginning(firstInt);
        int intToInsert1 = random.nextInt();
        list.insertAfter(firstInt, intToInsert1);

        //inserting after last
        int lastInt = random.nextInt();
        list.insertAtEnd(lastInt);
        int intToInsert2 = random.nextInt();
        list.insertAfter(lastInt, intToInsert2);

        //inserting at any position
        int intToInsert3 = random.nextInt();
        list.insertBefore(firstInt, intToInsert3);
    }

    @Test
    public void remove() {
        Integer size = list.size();
        int randomInt = random.nextInt();
        list.insertAtEnd(randomInt);
        int i = 0;
        while (list.removeFirstOccurrence(randomInt)) {
            i++;
        }
        assert size - i == list.size();
        assert list.removeFirstOccurrence(randomInt) == false;
    }

}