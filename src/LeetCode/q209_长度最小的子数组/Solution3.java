package LeetCode.q209_长度最小的子数组;

import static java.util.Arrays.binarySearch;

/**
 * @Author: Young
 * @Date: 2025/12/12 01:38
 *
 * 方法二：前缀和 + 二分查找
 */
public class Solution3 {
    public int minSubArrayLen(int target, int[] nums) {
        int length = nums.length;
        int min = Integer.MAX_VALUE;
        int[] sums = new int[length + 1];

        for (int i = 1; i < length; i++) {
            sums[i] = sums[i - 1] + nums[i - 1];
        }

        for (int i = 0; i < length; i++) {
            int toFind = target + sums[i];
            int bound = binarySearch(sums, toFind);
            if (bound < 0) {
                bound = -bound - 1;
            }

            if (bound <= length) {
                min = Math.min(min, bound - (i - 1));
            }

        }
        return min == Integer.MAX_VALUE ? 0 : min;
    }
}
