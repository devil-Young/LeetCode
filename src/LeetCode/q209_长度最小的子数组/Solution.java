package LeetCode.q209_长度最小的子数组;

/**
 * @Author: Young
 * @Date: 2025/12/12 01:03
 * <p>
 * 暴力  超时
 */
public class Solution {
    public int minSubArrayLen(int target, int[] nums) {
        int n = nums.length;
        int minLength = Integer.MAX_VALUE;
        for (int i = 0; i < n; i++) {
            int sum = 0;
            for (int j = i; j < n; j++) {
                sum += nums[j];
                if (sum >= target) {
                    minLength = Math.min(minLength, j - i + 1);
                    break;
                }
            }
        }
        return  minLength == Integer.MAX_VALUE ? 0 : minLength;
    }
}
