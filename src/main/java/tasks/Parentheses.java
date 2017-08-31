package tasks;

import datastruct.linkedlist.Stack;

public class Parentheses {
    public static char CLOSED_BRACKET = ']';
    public static char OPEN_BRACKET = '[';
    public static char CLOSED_CURLY_BRACE = '}';
    public static char OPEN_CURLY_BRACE = '{';
    public static char OPEN_PARENTHESES = '(';
    public static char CLOSED_PARENTHESES = ')';

    /**
     * checks if the value popped from stack is opposite parantheses to the current character.
     * If
     *
     * @param src
     * @return
     */
    public static boolean areParenthesesRight(String src) {
        Stack<Character> characterStack = new Stack<>();
        for (int i = 0, n = src.length(); i < n; i++) {
            Character currentChar = src.charAt(i);
            if (currentChar == CLOSED_BRACKET) {
                if (characterStack.pop() != OPEN_BRACKET) {
                    return false;
                }
            } else if (currentChar == CLOSED_CURLY_BRACE) {
                if (characterStack.pop() != OPEN_CURLY_BRACE) {
                    return false;
                }
            } else if (currentChar == CLOSED_PARENTHESES) {
                if (characterStack.pop() != OPEN_PARENTHESES) {
                    return false;
                }
            } else {
                characterStack.push(currentChar);
            }
        }
        return true;
    }
}
