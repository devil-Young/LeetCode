package LeetCode.q509_斐波那契数;

/**
 * @author biyangyang79989@zto.com
 * @version 1.0
 * @date 2026-10-16
 */
public class Solution {
    public int fib(int n) {
        //F(0) = 0，F(1) = 1
        if (n < 2) {
            return n;
        }
        //F(n) = F(n - 1) + F(n - 2)
        int p = 0, q = 0, r = 1;
        for (int i = 2; i <= n; i++) {
            p = q;
            q = r;
            r = p + q;
        }
        return r;
    }
}
