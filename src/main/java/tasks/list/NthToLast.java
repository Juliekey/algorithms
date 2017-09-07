package tasks.list;

import datastruct.linkedlist.Node;

import java.util.List;

public class NthToLast {
    public static Integer getNthToLast(Node<Integer> first, int n) {
        Node<Integer> pointer1 = first;
        Node<Integer> pointer2 = first;
        for (int i = 0; i < n; i++) {
            if (pointer2 == null) {
                throw new IllegalArgumentException("N is larger than number of items in the list");
            }
            pointer2 = pointer2.getNext();
        }
        while (pointer2.getNext() != null) {
            pointer1 = pointer1.getNext();
            pointer2 = pointer2.getNext();
        }
        return pointer1.getItem();
    }

    public static Integer getNthToLast(List<Integer> list, int n) {
        int length = list.size();
        int elementId = length - n - 1;
        return list.get(elementId);
    }
}
