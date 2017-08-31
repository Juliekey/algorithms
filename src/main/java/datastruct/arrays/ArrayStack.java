package datastruct.arrays;


import datastruct.interfaces.StackInterface;

import java.util.Iterator;

public class ArrayStack<Item> implements StackInterface<Item>, Iterable<Item> {
    private final static int RESIZE_COEF_ = 2;
    private static int ZERO_CAPACITY = 0;

    private Item[] arr = (Item[]) new Object[0];
    private int currIndex;

//
//    public Stack(int capacity) {
//        this.arr = (Item[]) new Object[capacity];
//        INITIAL_CAPACITY = capacity;
//    }


    public void push(Item item) {
        if (currIndex == arr.length) {
            resize(RESIZE_COEF_ * arr.length);
        }
        arr[currIndex++] = item;
    }

    public Item pop() {
        Item poppedItem = arr[currIndex--];
        arr[currIndex] = null; //avoid loitering
        if (currIndex > ZERO_CAPACITY && currIndex == arr.length / 4) {
            resize(arr.length / RESIZE_COEF_);
        }
        return poppedItem;
    }

    public Iterator<Item> iterator() {
        return new ReverseArrayIterator();
    }

    public boolean isEmpty() {
        return currIndex == 0;
    }

    @Override
    public int size() {
        return currIndex;
    }

    private void resize(int newArrLength) {
        Item[] temp = (Item[]) new Object[newArrLength];
        for (int i = 0; i < arr.length; i++) {
            temp[i] = arr[i];
        }
        arr = temp;
    }

    private class ReverseArrayIterator implements Iterator<Item> {
        private int n = currIndex;

        public boolean hasNext() {
            return n > 0;
        }

        public Item next() {
            return arr[n--];
        }
    }
}
