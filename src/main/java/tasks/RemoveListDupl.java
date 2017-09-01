package tasks;

import datastruct.linkedlist.DoublyLinkedListNode;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.Set;

public class RemoveListDupl {
    public static void remove(LinkedList<Integer> linkedList) {
        Set<Integer> hashSet = new HashSet<>();
        for (int i = 0; i < linkedList.size(); i++) {
            boolean wasAdded = hashSet.add(linkedList.get(i));
            if (!wasAdded) {
                linkedList.remove(i);
                i--;
            }
        }

    }

    //TODO fix
    public static void removeNoBufferAllowed(DoublyLinkedListNode<Integer> head) {
        DoublyLinkedListNode<Integer> current = head;
        while (current != null) {
            DoublyLinkedListNode followNode = current.getNext();
            Integer value = current.getItem();
            while (followNode != null) {
                if (followNode.getItem().equals(value)) {
                    DoublyLinkedListNode<Integer> nextNode = followNode.getNext();
                    DoublyLinkedListNode<Integer> prevNode = followNode.getPrev();
                    if (prevNode != null) {
                        prevNode.setNext(nextNode);
                    }
                    if (nextNode != null) {
                        nextNode.setPrev(prevNode);
                    }
                }
                followNode = followNode.getNext();
            }
            current = current.getNext();

        }

    }
}
