package q55_跳跃游戏;

/**
 * @Author: Young
 * @Date: 2025/6/5 21:20
 * 方法一：贪心
 *   记录最大可达位置
 */
public class Solution {
    public boolean canJump(int[] nums) {
        int n = nums.length;
        int maxReach = 0; // 最大可达位置
        for (int i = 0; i < n; i++) {
            if (i <= maxReach) {
                maxReach = Math.max(maxReach, nums[i] + i);
            }
            if (maxReach >= n - 1) {
                return true; // 如果最大可达位置已经超过或等于最后一个位置，返回 true
            }
        }
        return false; // 如果遍历完数组后仍未能到达最后一个位置，返回 false
    }
}
