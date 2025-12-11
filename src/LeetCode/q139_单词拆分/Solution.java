package q139_单词拆分;

import java.sql.Array;
import java.util.HashSet;
import java.util.List;

/**
 * @Author: Young
 * @Date: 2025/10/31 00:20
 */
public class Solution {
    public boolean wordBreak(String s, List<String> wordDict) {
        HashSet<String> wordSet = new HashSet<>(wordDict);
        boolean[] dp = new boolean[s.length() + 1];
        dp[0] = true;

        for (int i = 1; i < s.length(); i++) {
            for (int j = 0; j < i; j++) {
                if (dp[j] && wordSet.contains(s.substring(j, i))) {


                }
            }
        }
        return true;
    }
}
