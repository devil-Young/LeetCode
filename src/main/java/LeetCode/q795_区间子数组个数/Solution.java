package LeetCode.q795_区间子数组个数;

/**
 * @Author: Young
 * @Date: 2025/11/6 02:22
 */
public class Solution {
    public int numSubarrayBoundedMax(int[] nums, int left, int right) {
        int res = 0;
        int last1 = -1, last2 = -1;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] >= left && nums[i] <= right) {
                last1 = i;
            }else if (nums[i] >= right) {
                last2 = i;
                last1 = -1;
            }

            if (last1 != -1) {
                res += last1 - last2;
            }
        }

        return res;
    }
}
