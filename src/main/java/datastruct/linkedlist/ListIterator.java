package datastruct.linkedlist;

import java.util.Iterator;

public class ListIterator<Item> implements Iterator<Item> {
    private Node<Item> current;

    public ListIterator(Node current) {
        this.current = current;
    }

    @Override
    public boolean hasNext() {
        return current != null;
    }

    @Override
    public Item next() {
        Item item = current.getItem();
        current = current.getNext();
        return item;
    }
}
