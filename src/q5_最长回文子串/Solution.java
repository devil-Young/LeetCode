package q5_最长回文子串;

/**
 *
 */

/*
方法一  动态规划
 */
public class Solution {
    public String longestPalindrome(String s) {
        int len = s.length();
        if (len < 2) {
            return s;
        }

        int maxLen = 1;
        int begin = 0;
        // dp二维数组标识  i到j是否为回文串
        boolean[][] dp= new boolean[len][len];
        // 初始化 长度为1的子串为回文串
        for (int i = 0; i < len; i++) {
            dp[i][i] = true;
        }

        char[] charArray = s.toCharArray();
        // 子串长度从2开始循环
        for (int l = 2; l <= len; l++) {
            // 从左边开始
            for (int i = 0; i < len; i++) {
                // 右边界
                int j = i + l -1;
                // 越界
                if (j >= len){
                    break;
                }
                if(charArray[i] != charArray[j]){
                    dp[i][j] = false;
                }else {
                    if (l <= 2 ){
                        dp[i][j] = true;
                    }else {
                        dp[i][j] = dp[i+1][j-1];
                    }

                }

                if (dp[i][j] && j - i + 1 > maxLen){
                    maxLen = j - i + 1;
                    begin = i;
                }
            }
        }
        return s.substring(begin,begin + maxLen);
    }
}
