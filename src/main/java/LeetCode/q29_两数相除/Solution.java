package LeetCode.q29_两数相除;

public class Solution {
    public int divide(int divided, int divisor) {
        // 被除数为最小值
        if (divided == Integer.MIN_VALUE) {
            if (divisor == 1) {
                return Integer.MIN_VALUE;
            }
            if (divisor == -1) {
                return Integer.MAX_VALUE;
            }
        }
        // 除数为最小值
        if (divisor == Integer.MIN_VALUE) {
            return divided == Integer.MIN_VALUE ? 1 : 0;
        }
        if (divided == 0) {
            return 0;
        }

        // 使用二分查找
        // 将正数取相反数，这样只需考虑一种情况
        boolean rev = false;
        if (divided > 0) {
            divided = -divided;
            rev = !rev;
        }
        if (divisor > 0) {
            divisor = -divisor;
            rev = !rev;
        }
        return  divided + divisor;
    }

    // 快速乘
    public boolean quickAdd(int y, int z, int x) {
        // x ,y 负数  z正数
    return true;
    }
}
