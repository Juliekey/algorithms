package datastruct.linkedlist;

public class DoublyLinkedList<Item> {
    private Node first;
    private Node last;
    private int size;

    private class Node {
        Node next;
        Node prev;
        Item item;
    }

    public void insertAtBeginning(Item item) {

        Node oldFirst = first;
        first = new Node();
        first.item = item;
        size++;
        if (size == 1) {
            last = first;
        } else {
            first.next = oldFirst;
            oldFirst.prev = first;
        }

    }

    public void insertAtEnd(Item item) {
        Node oldLast = last;
        last = new Node();
        last.item = item;
        size++;
        if (size == 1) {
            first = last;
        } else {
            oldLast.next = last;
            last.prev = oldLast;
        }
    }

    public Item removeFromTheBeginning() {
        if (size == 0) {
            return null;
        }
        Item removedItem = first.item;
        first = first.next;
        size--;
        if (size == 0) {
            last = null;
        }
        return removedItem;
    }

    public Item removeFromTheEnd() {
        if (size == 0) {
            return null;
        }
        Item removedItem = last.item;
        last = last.prev;
        size--;
        if (size == 0) {
            first = null;
        }
        return removedItem;
    }

    public boolean insertBefore(Item item, Item itemToInsert) {
        for (Node node = first; node != null; node = node.next) {
            if (node.item.equals(item)) {
                size++;
                Node nodeToInsert = new Node();
                nodeToInsert.item = itemToInsert;
                nodeToInsert.next = node;
                Node nodeBefore = node.prev;
                node.prev = nodeToInsert;
//if we are inserting before the first node
                if (nodeBefore == null) {
                    first = nodeToInsert;
                } else {
                    nodeToInsert.prev = nodeBefore;
                    nodeBefore.next = nodeToInsert;
                }
                return true;
            }
        }
        return false;
    }

    public boolean insertAfter(Item item, Item itemToInsert) {
        for (Node node = first; node != null; node = node.next) {
            if (node.item.equals(item)) {
                size++;
                Node nodeToInsert = new Node();
                nodeToInsert.item = item;
                nodeToInsert.prev = node;
                Node nodeAfter = node.next;
                node.next = nodeToInsert;
                if (nodeAfter == null) {
                    last = nodeToInsert;
                } else {
                    nodeAfter.prev = nodeToInsert;
                    nodeToInsert.next = nodeAfter;
                }
                return true;

            }
        }
        return false;
    }

    public boolean removeFirstOccurrence(Item item) {
        for (Node node = first; node != null; node = node.next) {
            if (node.item.equals(item)) {
                size--;
                if (size == 0) {
                    first = last = null;
                }
                //removing first node
                else if (node.prev == null) {
                    first = node.next;
                    node.prev = null;
                }
//removing last node
                else if (node.next == null) {
                    last = node.prev;
                    node.prev.next = null;
                } else {
                    node.prev.next = node.next;
                }
                size--;
                return true;

            }
        }
        return false;
    }

    public Integer size() {
        return size;
    }

}
