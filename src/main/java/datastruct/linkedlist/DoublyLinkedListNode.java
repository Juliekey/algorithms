package datastruct.linkedlist;

public class DoublyLinkedListNode<Item> {
    private Item item;
    private DoublyLinkedListNode next;
    private DoublyLinkedListNode prev;

    public Item getItem() {
        return item;
    }

    public void setItem(Item item) {
        this.item = item;
    }

    public DoublyLinkedListNode getNext() {
        return next;
    }

    public void setNext(DoublyLinkedListNode next) {
        this.next = next;
    }

    public DoublyLinkedListNode getPrev() {
        return prev;
    }

    public void setPrev(DoublyLinkedListNode prev) {
        this.prev = prev;
    }
}
