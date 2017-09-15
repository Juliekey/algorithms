package tasks.arraysstrings;

public class RemoveDuplicatesFromString {
    public static void removeDuplicates(char[] chars) {
        if (chars == null) {
            return;
        }
        int n = chars.length;
        int tail = 1;
        if (n < 2) {
            return;
        }
        for (int i = 1; i < n; i++) {
            int j;
            for (j = 0; j < tail; j++) {
                if (chars[i] == chars[j]) {
                    break;
                }
            }
            if (j == tail) {
                chars[tail] = chars[i];
                tail++;
            }


        }

        chars[tail] = 0;
    }
}
