package LeetCode.q242_有效的字母异位词;

import java.util.Arrays;

/**
 * @author biyangyang79989@zto.com
 * @version 1.0
 * @date 2026-10-07
 */
//方法一：排序
public class Solution {
    public boolean isAnagram(String s, String t) {
        if (s.length() != t.length()) return false;
        char[] s1 = s.toCharArray();
        char[] t1 = t.toCharArray();
        Arrays.sort(s1);
        Arrays.sort(t1);
        return Arrays.equals(s1, t1);
    }
}
