package tasks.list;

import datastruct.linkedlist.Node;
import org.junit.Before;
import org.junit.Test;

import java.util.List;
import java.util.Random;
import java.util.concurrent.ThreadLocalRandom;

public class AddingListsTest {
    Node<Integer> first;
    Node<Integer> second;
    Random random = ThreadLocalRandom.current();
    public static final int FIRST_SIZE = 3;
    public static final int SECOND_SIZE = 3;
    public static final int RANGE = 10;

    @Before
    public void setUp() {
        first = new Node<>();
        second = new Node<>();
        fillNode(FIRST_SIZE, first);
        fillNode(SECOND_SIZE, second);

    }

    public void fillNode(int size, Node<Integer> node) {
        for (int i = 0; i < size; i++) {
            node.setItem(random.nextInt(RANGE));

            if (i != size - 1) {
                node.setNext(new Node<Integer>());
                node = node.getNext();
            }
        }
    }

    @Test
    public void add() throws Exception {
        Node<Integer> result = AddingLists.add(first, second);
        System.out.println(first);
        System.out.println(second);
        System.out.println(result);

    }

}