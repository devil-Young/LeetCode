package LeetCode.q415_字符串相加;

/**
 * @Author: Young
 * @Date: 2024/4/22 00:02
 */
public class Solution {
    public String addStrings(String num1, String num2) {
        int i = num1.length() - 1;
        int j = num2.length() - 1;
        // add 表示是否进位
        int add = 0;
        StringBuilder stringBuilder = new StringBuilder();
        while (i >= 0 || j >= 0 || add != 0) {
            int x = i >= 0 ? num1.charAt(i) - '0' : 0;
            int y = j >= 0 ? num2.charAt(j) - '0' : 0;
            int result = x + y + add;
            stringBuilder.append(result % 10);
            add = result / 10;
            i--;
            j--;
        }
        stringBuilder.reverse();
        return stringBuilder.toString();
    }
}
