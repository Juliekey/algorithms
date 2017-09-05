package datastruct.trees;


import org.junit.Before;
import org.junit.Test;

import java.util.*;
import java.util.concurrent.ThreadLocalRandom;

public class BinarySearchTreeTest {
    BinarySearchTree<Integer, Integer> binarySearchTree;
    Map<Integer, Integer> map;
    Random random = ThreadLocalRandom.current();
    private static final int NUMB_OF_EL = 10;
    private static final int RANGE = 50;

    @Before
    public void init() {
        binarySearchTree = new BinarySearchTree<>();
        map = new TreeMap<>();
        for (int i = 0; i < NUMB_OF_EL; i++) {
            Integer randomKey = random.nextInt(RANGE);
            Integer randomVal = random.nextInt(RANGE);

            map.put(randomKey, randomVal);
            binarySearchTree.put(randomKey, randomVal);
        }
    }

    @Test
    public void size() {
        assert map.size() == binarySearchTree.size();
    }

    @Test
    public void get() {
        Integer randomKey = random.nextInt(RANGE);
        Integer randomVal = random.nextInt(RANGE);

        map.put(randomKey, randomVal);
        binarySearchTree.put(randomKey, randomVal);
        assert map.get(randomKey).equals(binarySearchTree.get(randomKey));

    }

    @Test
    public void min() {
        assert Collections.min(map.keySet()).equals(binarySearchTree.min());

    }

    @Test
    public void max() {
        assert Collections.max(map.keySet()).equals(binarySearchTree.max());

    }

    @Test
    public void deleteMin() {
        Integer min = binarySearchTree.min();
        binarySearchTree.deleteMin();
        Iterable<Integer> keys = binarySearchTree.keys();
        for (Integer key : keys) {
            assert !key.equals(min);
        }

    }

    @Test
    public void delete() {
        Integer randomKey = random.nextInt(RANGE);
        Integer randomVal = random.nextInt(RANGE);
        binarySearchTree.put(randomKey, randomVal);
        int size = binarySearchTree.size();
        binarySearchTree.delete(randomKey);
        Iterable<Integer> keys = binarySearchTree.keys();
        for (Integer key : keys) {
            assert !key.equals(randomKey);
        }
        assert size - 1 == binarySearchTree.size();
    }

    @Test
    public void printKeysInOrder() {
        System.out.println("Search tree");
        binarySearchTree.printKeysInOrder();
        System.out.println("Map");
        System.out.println(map);

    }

    @Test
    public void keys() {
        Collection<Integer> values = map.values();
        Iterable<Integer> keys = binarySearchTree.keys();
    }

}