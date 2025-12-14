package LeetCode.q45_跳跃游戏II;

/**
 * @Author: Young
 * @Date: 2025/6/5 21:43
 * 贪心
 * 方法一：反向查找出发位置  反向贪心
 */
public class Solution {
    public int jump(int[] nums) {
        int position = nums.length -1;
        int step = 0;
        while (position > 0) {
            for (int i = 0; i < position; i++) {
                if (nums[i] + i >= position) {
                    position = i;
                    step++;
                    break;
                }
            }

        }
        return step;
    }
}
