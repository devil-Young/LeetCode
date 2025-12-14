package LeetCode.q279_完全平方数;

/**
 * @Author: Young
 * @Date: 2025/10/24 20:56
 */
public class Solution {
    public int numSquares(int n) {
        int[] f = new int[n + 1];
        for (int i = 1; i <= n; i++) {
            int minn = Integer.MAX_VALUE;
            for (int j = 1; j * j <= i; j++) {
                minn = Math.min(minn, f[i - j * j]);

            }
            f[i] = minn + 1;
        }
        return f[n];
    }
}
