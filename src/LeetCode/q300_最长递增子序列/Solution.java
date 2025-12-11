package q300_最长递增子序列;

/**
 * @Author: Young
 * @Date: 2025/11/8 18:07
 */
public class Solution {
    public int lengthOfLIS(int[] nums) {
        if (nums == null || nums.length == 0) return 0;

        int[] dp = new int[nums.length];
        dp[0] = 1;
        int maxLen = 1;

        for (int i = 1; i < nums.length; i++) {
            dp[i] = 1;
            for (int j = 0; j < i; j++) {
                if (nums[i] > nums[j]) {
                    dp[i] = Math.max(dp[i], dp[j] + 1);
                }
            }
            maxLen = Math.max(maxLen, dp[i]);
        }
        return maxLen;
    }
}
