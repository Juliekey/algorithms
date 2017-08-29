package datastruct.interfaces;

public interface BagInterface<Item> {
    void add(Item item);

    boolean isEmpty();

    int size();
}
