package LeetCode.q746_使用最小花费爬楼梯;

/**
 * @author biyangyang79989@zto.com
 * @version 1.0
 * @date 2026-10-25
 */
public class Solution2 {
    public int minCostClimbingStairs(int[] cost) {
        int n = cost.length;
        int first = 0, second = 0;
        for (int i = 2; i <= n; i++) {
            int current = Math.min(second + cost[i - 1], first + cost[i - 2]);
            first = second;
            second = current;
        }
        return second;
    }
}
