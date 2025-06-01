package q121_买卖股票的最佳时机;

/**
 * @Author: Young
 * @Date: 2025/6/1 15:02
 *
 * 方法二：一次遍历
 */
public class Solution2 {
    public int maxProfit(int[] prices) {
        int minPrice  = Integer.MAX_VALUE;
        int maxProfit = 0;
        for (int i = 0; i < prices.length; i++) {
            if (prices[i] < minPrice) {
                minPrice = prices[i];
            } else if (prices[i] - minPrice > maxProfit) {
                maxProfit = prices[i] - minPrice;
            }
        }
        return maxProfit;
    }
}
