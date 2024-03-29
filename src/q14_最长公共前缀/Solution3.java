package q14_最长公共前缀;

import java.util.Map;

/**
 * @Author: Young
 * @Date: 2023/9/9 00:48
 *
 * 分治法
 */
public class Solution3 {
    public String longestCommonPrefix(String[] strs){
        if (strs == null || strs.length == 0){
            return "";
        }else {
            return longestCommonPrefix(strs, 0, strs.length - 1);
        }
    }

    public String longestCommonPrefix(String[] strs, int start, int end){
        if (start == end){
            return strs[start];
        }else {
            int mid = (end - start) / 2 + start;
            String lcpLeft = longestCommonPrefix(strs, start, mid);
            String lcpRight = longestCommonPrefix(strs, mid + 1, end);
            return commonPrefix(lcpLeft, lcpRight);
        }
    }

    public String commonPrefix(String lcpLeft, String lcpRight){
        int minLength = Math.min(lcpLeft.length(), lcpRight.length());
        for (int i = 0; i < minLength; i++) {
            if (lcpLeft.charAt(i) != lcpRight.charAt(i)){
                return lcpLeft.substring(0, i);
            }
        }
        return lcpLeft.substring(0, minLength);
    }

}
