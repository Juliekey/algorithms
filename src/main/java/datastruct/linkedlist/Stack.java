package datastruct.linkedlist;

import datastruct.interfaces.StackInterface;

public class Stack<Item> implements StackInterface<Item> {

    private Node<Item> head;
    private int size;

    public Stack() {
    }

    //TODO items need to be cloned, not just moved
    public Stack(Stack<Item> stack) {
        Stack<Item> tempStack = new Stack<>();
        while (!stack.isEmpty()) {
            Item poppedItem = stack.pop();
            tempStack.push(poppedItem);
        }
        while (!tempStack.isEmpty()) {
            Item poppedItem = tempStack.pop();
            stack.push(poppedItem);
            this.push(poppedItem);
        }
    }

    public void push(Item item) {
        Node oldFirst = head;
        this.head = new Node();
        head.setItem(item);
        head.setNext(oldFirst);
        size++;
    }

    public Item pop() {
        Item item = head.getItem();
        head = head.getNext();
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

    public Stack<Item> gerReversed() {
        Stack<Item> newStack = new Stack<>();
        Stack<Item> tempStack = new Stack<>(this);

        while (!tempStack.isEmpty()) {
            newStack.push(tempStack.pop());
        }
        return newStack;
    }
}
