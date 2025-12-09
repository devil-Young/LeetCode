package q560_和为K的子数组;

/**
 * @Author: Young
 * @Date: 2025/2/12 23:29
 * 暴力解法的优化
 * 固定了起点，即先固定左边界，然后枚举右边界哈，时间复杂度降了一维。
 */
public class Solution {
    public int subarraySum(int[] nums, int k) {
        int count = 0;
        for (int start = 0; start < nums.length; start++) {
            int sum = 0;
            for (int end = start; end >= 0; end--) {
                sum += nums[end];
                if (sum == k) {
                    count++;
                }
            }
        }
        return count;
    }

    //暴力解法（超时）
    public int subarraySum1(int[] nums, int k) {
        int len = nums.length;
        int count = 0;
        for (int left = 0; left < len; left++) {
            for (int right = left; right < len; right++) {

                int sum = 0;
                for (int i = left; i <= right; i++) {
                    sum += nums[i];
                }
                if (sum == k) {
                    count++;
                }
            }
        }
        return count;
    }

}
