package tasks;

import org.junit.Test;

public class ParenthesesTest {
    @Test
    public void testParanthesesRightCase() {
        String src1 = "{[()]}";
        assert Parentheses.areParenthesesRight(src1) ;
        String src2 = "[()]{}{[()()]()}";
        assert Parentheses.areParenthesesRight(src2) ;
    }

    @Test
    public void testParanthesesWrongCase() {
        String src = "[(])";
        assert !Parentheses.areParenthesesRight(src);
    }
}
