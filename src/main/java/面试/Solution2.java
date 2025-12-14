import java.util.Deque;
import java.util.LinkedList;

/**
 * @Author: Young
 * @Date: 2025/12/1 12:25
 */
public class Solution2 {
    public boolean isValid(String s) {
        int n = s.length();

        Deque<Character> stack = new LinkedList<>();
        for (int i = 0; i < n; i++) {
            char c = s.charAt(i);
            if (c == '(' || c == '[' || c == '{') {
                stack.push(c);
            }else {
                if (stack.isEmpty()) return false;
                Character peek = stack.peek();
                if (c == ')' && peek == '(') {
                    stack.pop();
                } else if (c == ']' && peek == '[') {
                    stack.pop();
                } else if (c == '}' && peek == '{') {
                    stack.pop();
                } else {
                    return false;
                }
            }

        }return stack.isEmpty();
    }
}
