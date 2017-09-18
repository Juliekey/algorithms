package tasks.arraysstrings;

import tasks.ArraysUtil;

import java.util.Arrays;

public class RemoveDuplicatesFromString {
    public static Character[] removeDuplicates(Character[] chars) {
        if (chars == null) {
            return null;
        }
        int n = chars.length;
        int beginInex = 0;
        Character[] copyChars = Arrays.copyOf(chars, chars.length);
        if (n < 2) {
            return copyChars;
        }
        for (int i = 1; i < n; i++) {
            int j;
            for (j = beginInex; j < i; j++) {
                if (copyChars[i] == copyChars[j]) {
                    ArraysUtil.swap(copyChars, beginInex, j);
                    beginInex++;
                    break;
                }
            }
        }
        return Arrays.copyOfRange(copyChars, beginInex, copyChars.length);
    }

}
