package datastruct.hashtable;

import org.junit.Before;
import org.junit.Test;

import java.util.Random;
import java.util.concurrent.ThreadLocalRandom;

public class HashTableTest {
    HashTable<Integer, Integer> hashTable;
    Random random = ThreadLocalRandom.current();
    public final static int NUMB_OF_EL = 20;
    public final static int VALUE_RANGE = 59;


    @Test
    public void put() throws Exception {
        int size = hashTable.size();
        int randomKey = random.nextInt();
        int randomValue = random.nextInt(VALUE_RANGE);
        hashTable.put(randomKey, randomValue);
        assert size + 1 == hashTable.size();

    }

    @Test
    public void get() throws Exception {
        int randomKey = random.nextInt();
        int randomValue = random.nextInt(VALUE_RANGE);
        hashTable.put(randomKey, randomValue);
        hashTable.get(randomKey).equals(randomValue);
    }

    @Test
    public void delete() throws Exception {
        int randomKey = random.nextInt();
        int randomValue = random.nextInt(VALUE_RANGE);
        hashTable.put(randomKey, randomValue);
        int size = hashTable.size();
        hashTable.delete(randomKey);
        assert size - 1 == hashTable.size();
        assert hashTable.get(randomKey) == null;
    }

    @Test
    public void size() throws Exception {
        assert hashTable.size() == NUMB_OF_EL;
    }

}
