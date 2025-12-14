package LeetCode.q394_字符串解码;

import java.util.LinkedList;

/**
 * @Author: Young
 * @Date: 2025/11/3 04:30
 */
public class Solution {

    int ptr;

    public String decodeString(String s) {
        LinkedList<String> stk = new LinkedList<>();
        ptr = 0;

        while (ptr < s.length()) {
            char cur = s.charAt(ptr);
            if (Character.isDigit(cur)) {

            }

        }
        return  stk.pop();
    }

}
