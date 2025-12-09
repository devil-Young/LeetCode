package q45_跳跃游戏II;

/**
 * @Author: Young
 * @Date: 2025/6/5 22:42
 */
public class Solution2 {
    public int jump(int[] nums) {
        int length = nums.length;
        int end = 0;
        int maxPosition = 0;
        int step = 0;
        for (int i = 0; i < length - 1; i++) {
            maxPosition = Math.max(maxPosition, i + nums[i]);// 更新当前能到达的最远位置
            if (i == end) { // 到达最大位置
                end = maxPosition;
                step++; // 增加步数

            }
        }
        return step;


    }
}
