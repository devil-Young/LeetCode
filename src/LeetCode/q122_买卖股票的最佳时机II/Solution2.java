package q122_买卖股票的最佳时机II;

/**
 * @Author: Young
 * @Date: 2025/6/1 16:54
 *
 * 方法二：贪心
 */
public class Solution2 {
    public int maxProfit(int[] prices) {
        int ans = 0;
        int n = prices.length;
        for (int i = 1; i < n; i++) {
            ans += Math.max(0, prices[i] - prices[i - 1]);
        }
        return ans;

    }
}
