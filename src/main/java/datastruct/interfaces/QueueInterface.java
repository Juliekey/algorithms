package datastruct.interfaces;

public interface QueueInterface<Item> extends Iterable<Item> {

    void enqueue(Item item);

    Item dequeue();

    boolean isEmpty();

    int size();
}
