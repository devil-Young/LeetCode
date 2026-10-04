package LeetCode.q231_2的幂;

/**
 * @author biyangyang79989@zto.com
 * @version 1.0
 * @date 2026-10-04
 */
public class Solution2 {
    static final int MAX = 1 << 30;
    public boolean isPowerOfTwo(int n) {
        return n > 0 && MAX % n == 0;
    }
}
