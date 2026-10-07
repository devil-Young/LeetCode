package LeetCode.q242_有效的字母异位词;

import java.util.HashMap;

/**
 * @author biyangyang79989@zto.com
 * @version 1.0
 * @date 2026-10-07
 */
// 进阶问题
public class Solution3 {
    public boolean isAnagram(String s, String t) {
        if(s.length() != t.length()) {
            return false;
        }
        HashMap<Character, Integer> table = new HashMap<>();
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            table.put(c, table.getOrDefault(c, 0) + 1);
        }
        for (int i = 0; i < t.length(); i++) {
            char c = t.charAt(i);
            if(!table.containsKey(c)) {
                return false;
            }
            table.put(c, table.getOrDefault(c, 0) - 1);
            if(table.get(c) < 0) {
                return false;
            }
        }
        return true;
    }
}
