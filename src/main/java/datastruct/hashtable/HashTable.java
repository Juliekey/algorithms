package datastruct.hashtable;

public abstract class HashTable<Key, Value> {
    protected int size;
    protected int m;

    public abstract void put(Key key, Value value);

    public abstract Value get(Key key);

    public abstract Value delete(Key key);

    public abstract int size();

    protected int hash(Key key) {
        return key.hashCode() & 0x7FFFFFFF % m;
    }
}
