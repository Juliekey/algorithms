package datastruct.arrays;

import datastruct.interfaces.QueueInterface;

import java.util.Iterator;

public class ArrayQueue<Item> implements QueueInterface<Item> {
    private Item[] items = (Item[]) new Object[1];
    private int size;

    public void enqueue(Item item) {
        items[size++] = item;
        if (size == items.length) {
            resize(items.length * 2);
        }

    }

    public Item dequeue() {

        Item poppedItem = items[0];
        moveItems();
        size--;
        if (size > 0 && size < items.length / 4) {
            resize(items.length / 2);
        }
        return poppedItem;
    }

    private void resize(int length) {
        Item[] newItems = (Item[]) new Object[length];
        for (int i = 0; i < size; i++) {
            newItems[i] = items[i];
        }
        items = newItems;
    }

    private void moveItems() {
        Item[] newItems = (Item[]) new Object[items.length];
        for (int i = 1, j = 0; i < size; i++, j++) {
            newItems[j] = items[i];
        }
        items = newItems;

    }


    public int size() {
        return size;
    }

    public boolean isEmpty() {
        return size == 0;
    }

    @Override
    public Iterator<Item> iterator() {
        return new ArrayIterator();
    }

    private class ArrayIterator implements Iterator<Item> {
        int current;

        @Override
        public boolean hasNext() {
            return current < size;
        }

        @Override
        public Item next() {
            Item toReturn = items[current];
            current++;
            return toReturn;
        }
    }
}
