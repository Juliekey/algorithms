package datastruct.interfaces;

public interface StackInterface<Item> {
    void push(Item item);

    Item pop();

    boolean isEmpty();

    int size();
}
