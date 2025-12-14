package LeetCode.q50_Pow;

/**
 * @Author: Young
 * @Date: 2023/12/22 22:21
 * 利用十进制数字的二进制表示，可对快速幂进行数学化解释
 * 将指数改写为二进制
 */
public class Solution2 {
    public double myPow(double x, int n) {
        long N = n;
        return N >= 0 ? quickMul(x, N) : 1.0 / quickMul(x, -N);
    }
    private double quickMul(double x, long N) {
        double res = 1.0;
        while (N > 0) {
            if ((N & 1) == 1) {
                res *= x;
            }
            x *= x;
            N >>= 1;
        }
        return res;
    }
}
