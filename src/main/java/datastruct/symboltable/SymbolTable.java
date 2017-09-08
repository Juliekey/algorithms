package datastruct.symboltable;

import com.sun.istack.internal.NotNull;
import datastruct.linkedlist.LinkedListQueue;

public class SymbolTable<Key, Value> {
    private int size;
    private Node first;

    public boolean put(@NotNull Key key, Value value) {
        for (Node current = first; current != null; current = current.next) {
            if (current.key.equals(key)) {
                current.value = value;
                return false;
            }
        }
        first = new Node(key, value, first);
        size++;
        return true;

    }

    public Value get(Key key) {
        for (Node current = first; current != null; current = current.next) {
            if (current.key.equals(key)) {
                return current.value;
            }
        }
        return null;
    }

    public Value delete(Key key) {
        if (first == null) {
            return null;
        }
        if (first.key.equals(key)) {
            Value value = first.value;
            first = first.next;
            size--;
            return value;
        }
        for (Node prev = first, current = first.next; current != null; current = current.next, prev = prev.next) {
            if (current.key.equals(key)) {
                prev.next = current.next;
                size--;
                return current.value;
            }
        }
        return null;

    }

    public boolean isEmpty() {
        return size == 0;
    }

    public int size() {
        return size;
    }

    public Iterable<Key> keys() {
        LinkedListQueue<Key> queue = new LinkedListQueue<>();
        for (Node current = first; current != null; current = current.next) {
            queue.enqueue(current.key);
        }
        return queue;
    }

    private class Node {
        Key key;
        Value value;
        Node next;

        public Node(Key key, Value value, Node next) {
            this.key = key;
            this.value = value;
            this.next = next;
        }
    }
}
