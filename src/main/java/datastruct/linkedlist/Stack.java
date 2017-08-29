package datastruct.linkedlist;

import datastruct.interfaces.StackInterface;

public class Stack<Item> implements StackInterface<Item> {

    private Node<Item> first;
    private int size;


    public void push(Item item) {
        Node oldFirst = first;
        this.first = new Node();
        first.setItem(item);
        first.setNext(oldFirst);
        size++;
    }

    public Item pop() {
        Item item = first.getItem();
        first = first.getNext();
        size--;
        return item;
    }

    @Override
    public boolean isEmpty() {
        return size == 0;
    }

    public int size() {
        return size;
    }
}
