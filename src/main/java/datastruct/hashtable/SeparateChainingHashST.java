package datastruct.hashtable;

import datastruct.symboltable.SymbolTable;


public class SeparateChainingHashST<Key, Value> extends HashTable<Key, Value> {
    private final static int INITIAL_SIZE = 997;

    private SymbolTable<Key, Value>[] arr;

    public SeparateChainingHashST() {
        arr = (SymbolTable<Key, Value>[]) new SymbolTable[INITIAL_SIZE];
        for (int i = 0; i < INITIAL_SIZE; i++) {
            arr[i] = new SymbolTable<>();
        }
        this.m = INITIAL_SIZE;
    }

    public void put(Key key, Value value) {
        boolean wasPut = arr[hash(key)].put(key, value);
        if (wasPut) {
            size++;
        }

    }

    public Value get(Key key) {
        return arr[hash(key)].get(key);
    }

    public Value delete(Key key) {
        Value value = arr[hash(key)].delete(key);
        if (value != null) {
            size--;
        }
        return value;

    }

    public int size() {
        return size;
    }
}
