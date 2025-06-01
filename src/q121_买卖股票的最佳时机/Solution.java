package q121_买卖股票的最佳时机;

/**
 * @Author: Young
 * @Date: 2025/6/1 14:52
 * <p>
 * 方法一：暴力法【超时】
 */
public class Solution {
    public int maxProfit(int[] prices) {
        int maxProfit = 0;
        for (int i = 0; i < prices.length - 1; i++) {
            for (int j = i + 1; j < prices.length; j++) {
                int profit = prices[j] - prices[i];
                if (profit > maxProfit) {
                    maxProfit = profit;
                }
            }
        }
        return maxProfit;
    }
}
