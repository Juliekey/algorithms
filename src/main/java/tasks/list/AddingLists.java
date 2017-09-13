package tasks.list;

import datastruct.linkedlist.Node;

public class AddingLists {
    public static int MAX = 10;

    public static Node<Integer> add(Node<Integer> first, Node<Integer> second) {
        Node<Integer> result = new Node<>();
        Node<Integer> current = result;
        Node<Integer> copyFirst = first;
        Node<Integer> copySecond = second;
        int remainder = 0;
        while (copyFirst != null && copySecond != null) {
            int sum = copyFirst.getItem() + copySecond.getItem() + remainder;
            if (sum >= MAX) {
                remainder = 1;
                current.setItem(sum - MAX);
            } else {
                remainder = 0;
                current.setItem(sum);
            }
            copyFirst = copyFirst.getNext();
            copySecond = copySecond.getNext();
            if (copyFirst != null && copySecond != null) {
                current.setNext(new Node());
                current = current.getNext();
            }
        }
        if (copyFirst != null) {
            copy(copyFirst, current, remainder);
        } else {
            copy(copySecond, current, remainder);
        }
        return result;
    }

    private static void copy(Node<Integer> copyFrom, Node<Integer> copyTo, int remainder) {
        while (copyFrom != null) {
            int sum = copyFrom.getItem() + remainder;
            if (sum >= MAX) {
                copyTo.setItem(sum - MAX);
                remainder = 1;
            } else {
                copyTo.setItem(sum);
                remainder = 0;
            }
            copyFrom = copyFrom.getNext();
            if (copyFrom != null) {
                copyTo.setNext(new Node<Integer>());
                copyFrom = copyTo.getNext();
            }
        }
    }
}
