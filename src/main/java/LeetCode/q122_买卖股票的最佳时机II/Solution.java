package LeetCode.q122_买卖股票的最佳时机II;

/**
 * @Author: Young
 * @Date: 2025/6/1 15:20
 *
 * 方法一：动态规划
 */
public class Solution {
    public int maxProfit(int[] prices) {
        int n = prices.length;
        int [][] dp = new int[n][2];
        // 0 表示不持有股票，1 表示持有股票
        // 初始状态
        dp[0][0] = 0; // 第一天不持有股票
        dp[0][1] = -prices[0]; // 第一天持有股票，花费为当天的价格

        for (int i = 1; i < n; i++) {
            dp[i][0] = Math.max(dp[i - 1][0], dp[i - 1][1] + prices[i]); // 不持有股票的最大利润
            dp[i][1] = Math.max(dp[i - 1][1], dp[i - 1][0] - prices[i]); // 持有股票的最大利润
        }

        return dp[n - 1][0];
    }
}
