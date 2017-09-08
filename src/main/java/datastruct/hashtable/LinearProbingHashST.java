package datastruct.hashtable;

import java.util.Arrays;

public class LinearProbingHashST<Key, Value> extends HashTable<Key, Value> {
    private final static int INIT_SIZE = 223;
    private Key[] keys = (Key[]) new Object[INIT_SIZE];
    private Value[] values = (Value[]) new Object[INIT_SIZE];

    public LinearProbingHashST() {
        m = INIT_SIZE;
    }

    @Override
    public void put(Key key, Value value) {
        if (size > m / 2) {
            resize(m * 2);
        }
        int index = getKeyIndex(key);
        if (keys[index] == null) {
            size++;
        }
        keys[index] = key;
        values[index] = value;
    }

    @Override
    public Value get(Key key) {
        int index = getKeyIndex(key);
        return values[index];
    }

    private int getKeyIndex(Key key) {
        int index = hash(key);
        while (keys[index] != null && !key.equals(keys[index])) {
            index = index++ % m;
        }
        return index;
    }

    @Override
    public Value delete(Key key) {
        if (size < m / 4) {
            resize(m / 4);
        }
        int index = getKeyIndex(key);
        Value deletedValue = values[index];
        keys[index] = null;
        values[index] = null;
        index++;
        while (keys[index % m] != null) {
            Key movedKey = keys[index];
            Value movedValue = values[index];
            keys[index] = null;
            values[index] = null;
            put(movedKey, movedValue);
            index++;
        }
        return deletedValue;
    }

    @Override
    public int size() {
        return size;

    }

    private void resize(int newSize) {
        Key[] copyKey = Arrays.copyOf(keys, m);
        Value[] copyValue = Arrays.copyOf(values, m);

        keys = (Key[]) new Object[newSize];
        values = (Value[]) new Object[newSize];

        for (int i = 0; i < m; i++) {
            if (copyKey[i] != null) {
                put(copyKey[i], copyValue[i]);
            }
        }
        m = newSize;
    }

}
