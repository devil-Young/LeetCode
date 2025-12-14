package LeetCode.q7_整数反转;

/**
 * @Author: Young
 * @Date: 2023/9/6 01:18
 */
public class Solution {
    public int reverse(int x){

        int rev = 0;
        while (x != 0){
            if (rev < Integer.MIN_VALUE / 10 || rev > Integer.MAX_VALUE / 10) {
                return 0;
            }
            int digit = x % 10;
            x /= 10;
            rev = rev * 10 + digit;
        }
        return rev;
    }
}
