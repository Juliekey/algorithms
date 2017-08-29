package datastruct.linkedlist;

import datastruct.interfaces.QueueInterface;

import java.util.Iterator;

public class Queue<Item> implements QueueInterface<Item>, Iterable<Item> {
    private Node<Item> first;
    private Node<Item> last;
    private int size;

    @Override
    public void enqueue(Item item) {
        Node oldLast = last;
        last = new Node();
        last.setItem(item);
        if (isEmpty()) {
            first = last;
        } else {
            oldLast.setNext(last);

        }

        size++;

    }

    @Override
    public Item dequeue() {
        Item item = first.getItem();
        first = first.getNext();
        size--;
        if (isEmpty()) {
            last = null;
        }
        return item;
    }

    @Override
    public boolean isEmpty() {
        return size == 0;
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public Iterator<Item> iterator() {
        return new ListIterator<>(first);
    }
}
