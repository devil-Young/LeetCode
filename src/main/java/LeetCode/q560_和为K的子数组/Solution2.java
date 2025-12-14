package LeetCode.q560_和为K的子数组;

/**
 * @Author: Young
 * @Date: 2025/2/13 00:08
 * 暴力解法的优化
 */
public class Solution2 {
    public int subarraySum(int[] nums, int k) {
        int len = nums.length;
        // 前缀数组
        int[] preSum = new int[len + 1];
        preSum[0] = 0;

        for (int i = 0; i < len; i++) {
            preSum[i + 1] = preSum[i] + nums[i];
        }

        int count = 0;
        for (int left = 0; left < len; left++) {
            for (int right = left; right < len; right++) {
                if (preSum[right + 1] - preSum[left] == k) {
                    count++;
                }
            }
        }
        return count;
    }
}
