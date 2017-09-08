package datastruct.hashtable;

import org.junit.Before;

public class SeparateChainingHashSTTest extends HashTableTest {

    @Before
    public void init() {
        hashTable = new SeparateChainingHashST();

        for (int i = 0; i < NUMB_OF_EL; i++) {
            hashTable.put(random.nextInt(), random.nextInt(VALUE_RANGE));
        }
    }

}