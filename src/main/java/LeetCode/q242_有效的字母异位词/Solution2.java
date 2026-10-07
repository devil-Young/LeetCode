package LeetCode.q242_有效的字母异位词;

/**
 * @author biyangyang79989@zto.com
 * @version 1.0
 * @date 2026-10-07
 */
// 哈希表
public class Solution2 {
    public boolean isAnagram(String s, String t) {
        if (s.length() != t.length()) {
            return false;
        }
        int[] table = new int[26];
        for (int i = 0; i < s.length(); i++) {
            table[s.charAt(i) - 'a']++;
        }
        for (int i = 0; i < t.length(); i++) {
            table[t.charAt(i) - 'a']--;
        }
        for (int i = 0; i < table.length; i++) {
            if (table[i] != 0) {
                return false;
            }
        }
        return true;
    }
}
