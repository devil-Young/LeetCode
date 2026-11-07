package LeetCode.q343_整数拆分;

/**
 * @author biyangyang79989@zto.com
 * @version 1.0
 * @date 2026-11-07
 */
public class Solution {
    public int integerBreak(int n) {
        int[] dp = new int[n + 1];
        for (int i = 2; i <= n; i++) {
            for (int j = 1; j < i; j++) {
                dp[i] = Math.max(Math.max((j * (i - j)), j * dp[i - j]), dp[i]);
            }
        }
        return dp[n];
    }
}
