package tasks.arraysstrings;

import org.junit.Test;

import java.util.Arrays;

public class RemoveDuplicatesFromStringTest {

    @Test
    public void removeDuplicatesNoDupl() throws Exception {
        char[] str = {'a', 'b', 'c', 'd'};
        char[] copy = Arrays.copyOf(str, str.length);
        RemoveDuplicatesFromString.removeDuplicates(str);
        System.out.println(str);
        assert copy.equals(str);
    }

    @Test
    public void removeDuplicatesWithDupl() throws Exception {
        char[] str = {'a', 'b', 'b', 'c', 'd', 'c', 'd'};
        char[] right = {'a', 'b', 'c', 'd'};
        RemoveDuplicatesFromString.removeDuplicates(str);
        System.out.println(str);
        assert right.equals(str);
    }
}