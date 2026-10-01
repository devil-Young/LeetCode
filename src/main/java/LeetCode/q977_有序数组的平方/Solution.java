package LeetCode.q977_有序数组的平方;

import java.util.Arrays;

/**
 * @author biyangyang79989@zto.com
 * @version 1.0
 * @date 2026-10-01
 */
public class Solution {
    public int[] sortedSquares(int[] nums) {
        int[] ans = new int[nums.length];
        for (int i = 0; i < nums.length; i++) {
            ans[i] = nums[i] * nums[i];
        }
        Arrays.sort(ans);
        return ans;
    }
}
