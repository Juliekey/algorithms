package tasks;

import datastruct.linkedlist.DoublyLinkedListNode;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.Random;
import java.util.Set;
import java.util.concurrent.ThreadLocalRandom;

class RemoveListDuplTest {
    static LinkedList<Integer> linkedList = new LinkedList<>();
    static DoublyLinkedListNode<Integer> node = new DoublyLinkedListNode<>();
    public final static int NUMB_OF_EL = 20;
    public final static int RANGE = 5;
    static Set<Integer> testData = new HashSet<>();

    @BeforeAll
    public static void setUp() {
        Random random = ThreadLocalRandom.current();
        DoublyLinkedListNode<Integer> copy = node;
        DoublyLinkedListNode<Integer> prev = null;

        for (int i = 0; i < NUMB_OF_EL; i++) {
            Integer randomInt = random.nextInt(RANGE);
            linkedList.add(randomInt);
            testData.add(randomInt);
            copy.setItem(randomInt);
            DoublyLinkedListNode<Integer> next = new DoublyLinkedListNode<>();
            copy.setNext(next);
            copy = copy.getNext();
            copy.setPrev(prev);
            prev = copy;
        }
    }

    @Test
    void remove() {
        assert linkedList.size() != testData.size();
        RemoveListDupl.remove(linkedList);
        assert linkedList.size() == testData.size();
    }

    @Test
    void removeNoBufferAllowed() {
        RemoveListDupl.removeNoBufferAllowed(node);
        int size = 0;
        while (node != null) {
            size++;
            node = node.getNext();
        }
        assert size == testData.size();

    }

}