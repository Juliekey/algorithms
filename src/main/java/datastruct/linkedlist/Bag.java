package datastruct.linkedlist;

import datastruct.interfaces.BagInterface;

import java.util.Iterator;

public class Bag<Item> implements BagInterface<Item>, Iterable<Item> {
    private Node<Item> first;
    private int size = 0;

    public void add(Item item) {
        Node oldFirst = first;
        first = new Node();
        first.setItem(item);
        first.setNext(oldFirst);
        size++;
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
