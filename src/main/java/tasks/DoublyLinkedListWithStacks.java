package tasks;

import datastruct.linkedlist.Stack;

import java.util.Iterator;

public class DoublyLinkedListWithStacks<Item> implements Iterable<Item> {
    private Stack<Item> headStack = new Stack<>();
    private Stack<Item> tailStack = new Stack<>();

    public void addFirst(Item item) {
        headStack.push(item);
    }

    public void addLast(Item item) {
        tailStack.push(item);
    }

    public Item removeFirst() {
        return headStack.pop();
    }

    public Item removeLast()

    {
        return tailStack.pop();
    }

    public boolean remove(Item item) {
        boolean isDeleted = deleteFromStack(headStack, tailStack, item);
        return isDeleted ? isDeleted : deleteFromStack(tailStack, headStack, item);
    }

    private boolean deleteFromStack(Stack<Item> firstStack, Stack<Item> secondStack, Item item) {
        int poppedItems = 0;
        boolean isFound = false;
        while (!firstStack.isEmpty()) {
            Item poppedItem = firstStack.pop();
            if (poppedItem.equals(item)) {
                isFound = true;
            } else {
                poppedItems++;
                secondStack.push(poppedItem);
            }
        }
        for (int i = 0; i < poppedItems; i++) {
            firstStack.push(secondStack.pop());
        }
        return isFound;

    }

    public int size() {
        return headStack.size() + tailStack.size();
    }

    public Iterator<Item> iterator() {
        return new StackListIterator();
    }

    private class StackListIterator implements Iterator<Item> {
        int listSize = size();
        int headStackSize = headStack.size();

        Stack<Item> headStackCopy = new Stack<>(headStack);
        Stack<Item> reversedTailStack = tailStack.gerReversed();

        int currentIndex = 0;

        public boolean hasNext() {
            if (currentIndex < listSize) {
                return true;
            }
            return false;
        }

        public Item next() {
            if (currentIndex < headStackSize) {
                Item item = headStackCopy.pop();
                currentIndex++;
                return item;
            } else {
                Item item = reversedTailStack.pop();
                currentIndex++;
                return item;
            }
        }

    }
}
