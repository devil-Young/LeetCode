package q70_爬楼梯;

/**
 * @Author: Young
 * @Date: 2025/6/3 15:15
 * 方法一：动态规划
 * f(x)=f(x−1)+f(x−2)
 */
public class Solution {
    public int climbStairs(int n) {
        int p = 0, q = 0, r = 1;
        for (int i = 1; i <= n; i++) {
            p = q;
            q = r;
            r = p + q;
        }
        return r;
    }
}
