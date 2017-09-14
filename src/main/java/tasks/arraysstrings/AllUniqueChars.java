package tasks.arraysstrings;

public class AllUniqueChars {
    static boolean[] char_set = new boolean[256];

    public static boolean areAllCharsUnique(String s) {
        for (int i = 0, n = s.length(); i < n; i++) {
            if (char_set[i]) {
                return false;
            }
            char_set[i] = true;
        }
        return true;

    }

    public static boolean areAllCharUnique(String s) {
        int checker = 0;
        for (int i = 0, n = s.length(); i < n; i++) {
            int val = s.charAt(i) - 'a';
            if ((checker & (1 << val)) > 0) {
                return false;
            }
            checker |= 1 << val;
        }
        return true;
    }
}
