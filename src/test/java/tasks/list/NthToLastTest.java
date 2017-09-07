package tasks.list;

import datastruct.linkedlist.Node;
import org.junit.Before;
import org.junit.Test;

import java.util.LinkedList;
import java.util.Random;
import java.util.concurrent.ThreadLocalRandom;

public class NthToLastTest {
    Node<Integer> head;
    LinkedList<Integer> linkedList;
    public final static int NUMB_OF_EL = 20;
    public final static int RANGE = 20;
    public final static int N = 5;

    Random random = ThreadLocalRandom.current();

    @Before
    public void setUp() {
        head = new Node();
        Node<Integer> current = head;
        linkedList = new LinkedList<>();
        for (int i = 0; i < NUMB_OF_EL; i++) {
            Integer randomInt = random.nextInt(RANGE);
            linkedList.add(randomInt);
            current.setItem(randomInt);
            if (i != RANGE - 1) {
                Node<Integer> newNode = new Node<>();
                current.setNext(newNode);
                current  = newNode;
            }
        }
    }

    @Test
    public void getNthToLast() throws Exception {
        System.out.println("test");
        assert NthToLast.getNthToLast(head, N) == NthToLast.getNthToLast(linkedList, N);
    }
}
