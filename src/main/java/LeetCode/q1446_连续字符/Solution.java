package LeetCode.q1446_连续字符;

/**
 * @Author: Young
 * @Date: 2025/12/9 13:17
 */
public class Solution {
    public int maxPower(String s) {
        int n = s.length();
        int maxCount = 1;
        int res = 1;

        for (int i = 1; i < n; i++) {
            char pre = s.charAt(i - 1);
            char cur = s.charAt(i);
            if (pre == cur) {
                maxCount++;
                res = Math.max(maxCount, res);
            }else {

                maxCount = 1;
            }
        }

        return  res;
    }
}
