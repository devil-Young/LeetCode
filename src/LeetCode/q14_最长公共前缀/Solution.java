package q14_最长公共前缀;

import java.util.Map;

/**
 * @Author: Young
 * @Date: 2023/9/8 23:40
 *
 * 横向扫描
 */
public class Solution {
    public String longestCommonPrefix(String[] strs){
        if (strs == null || strs.length == 0){
            return "";
        }
        String prefix  = strs[0];
        int count = strs.length;
        for (int i = 1; i < count; i++) {
            prefix = longestCommonPrefix(prefix, strs[i]);
            if (prefix.isEmpty()){
                break;
            }
        }
        return prefix;
    }

    public String longestCommonPrefix(String str1, String str2){
        int length = Math.min(str1.length(), str2.length());
        int index = 0;
        while (index < length && str1.charAt(index) == str2.charAt(index)){
            index++;
        }
        return str1.substring(0, index);
    }
}
