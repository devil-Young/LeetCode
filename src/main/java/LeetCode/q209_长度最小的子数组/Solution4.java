package LeetCode.q209_长度最小的子数组;

/**
 * @author biyangyang79989@zto.com
 * @version 1.0
 * @date 2026-10-01
 */
// 滑动窗口
public class Solution4 {
    public int minSubArrayLen(int target, int[] nums) {
        int n = nums.length;
        if (n == 0) return 0;
        int ans = Integer.MAX_VALUE;
        int sum = 0;
        int start = 0;
        for (int end = 0; end < n; end++) {
            sum += nums[end];
            while (sum >= target) {
                ans = Math.min(ans, end - start + 1);
                sum -= nums[start];
                start++;
            }
        }
         return ans == Integer.MAX_VALUE ? 0 : ans;
    }
}
