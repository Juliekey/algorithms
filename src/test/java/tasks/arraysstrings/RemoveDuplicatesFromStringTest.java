package tasks.arraysstrings;

import org.junit.Test;

import java.util.Arrays;

public class RemoveDuplicatesFromStringTest {

    @Test
    public void removeDuplicatesNoDupl() throws Exception {
        Character[] str = {'a', 'b', 'c', 'd'};
        Character[] copy = Arrays.copyOf(str, str.length);
        str = RemoveDuplicatesFromString.removeDuplicates(str);
        System.out.println(Arrays.toString(str));
        assert Arrays.equals(copy, str);
    }

    @Test
    public void removeDuplicatesWithDupl() throws Exception {
        Character[] str = {'a', 'b', 'b', 'c', 'd', 'c', 'd'};
        Character[] right = {'a', 'b', 'c', 'd'};
        str = RemoveDuplicatesFromString.removeDuplicates(str);
        System.out.println(Arrays.toString(str));
        assert Arrays.equals(right, str);
    }
}