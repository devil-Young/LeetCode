package q70_爬楼梯;

/**
 * @Author: Young
 * @Date: 2025/6/3 15:49
 * 方法三：通项公式
 */
public class Solution3 {

    public int climbStairs(int n) {
        double sqrt5 = Math.sqrt(5);
        double fibn = Math.pow((1 + sqrt5) / 2, n + 1) - Math.pow((1 - sqrt5) / 2, n + 1);
        return (int) Math.round(fibn / sqrt5);
    }

}
