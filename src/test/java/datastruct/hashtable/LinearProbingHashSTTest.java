package datastruct.hashtable;

import org.junit.Before;

public class LinearProbingHashSTTest extends HashTableTest {
    @Before
    public void setUp() throws Exception {
        hashTable = new LinearProbingHashST<>();

        for (int i = 0; i < NUMB_OF_EL; i++) {
            hashTable.put(random.nextInt(), random.nextInt(VALUE_RANGE));
        }
    }

}