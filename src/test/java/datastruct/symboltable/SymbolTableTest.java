package datastruct.symboltable;

import org.junit.Before;
import org.junit.Test;

import java.util.HashMap;
import java.util.Map;
import java.util.Random;
import java.util.concurrent.ThreadLocalRandom;

public class SymbolTableTest {
    SymbolTable<Integer, Integer> symbolTable;
    Map<Integer, Integer> testData;
    Random random = ThreadLocalRandom.current();
    public final static int NUMB_OF_EL = 20;
    public final static int VALUE_RANGE = 5;
    public final static int KEY_RANGE = 1000;

    @Before
    public void init() {
        symbolTable = new SymbolTable<>();
        testData = new HashMap<>();
        for (int i = 0; i < NUMB_OF_EL; i++) {
            int key = this.random.nextInt(KEY_RANGE);
            int value = this.random.nextInt(VALUE_RANGE);

            symbolTable.put(key, value);
            testData.put(key, value);
        }
    }

    @Test
    public void put() throws Exception {
        int oldSize = symbolTable.size();
        int key = this.random.nextInt(KEY_RANGE);
        int value = this.random.nextInt(VALUE_RANGE);
        symbolTable.put(key, value);
        assert oldSize + 1 == symbolTable.size();

    }

    @Test
    public void get() throws Exception {
        int key = this.random.nextInt(KEY_RANGE);
        int value = this.random.nextInt(VALUE_RANGE);
        symbolTable.put(key, value);
        assert symbolTable.get(key).equals(value);
    }

    @Test
    public void delete() throws Exception {

        int key = this.random.nextInt(KEY_RANGE);
        int value = this.random.nextInt(VALUE_RANGE);
        symbolTable.put(key, value);

        int oldSize = symbolTable.size();

        Integer deletedVal = symbolTable.delete(key);
        assert deletedVal.equals(value);
        assert symbolTable.get(key) == null;
        assert oldSize - 1 == symbolTable.size();
    }

    @Test
    public void isEmpty() throws Exception {
        assert symbolTable.isEmpty() == false;
    }

    @Test
    public void size() throws Exception {
        assert testData.size() == symbolTable.size();
    }


}