package q128_最长连续序列;

import java.util.HashSet;

/**
 * @Author: Young
 * @Date: 2025/2/7 21:57
 */
public class Solution {
    public int longestConsecutive(int[] nums) {
        HashSet<Integer> hashSet = new HashSet<>();
        for (Integer num : nums) {
            hashSet.add(num);
        }

        int longestStreak = 0;
        for (Integer num : hashSet) {
            if (!hashSet.contains(num -1)) {
                int currentNum = num;
                int currentStreak = 1;

                while (hashSet.contains(currentNum + 1)) {
                    currentNum += 1;
                    currentStreak += 1;
                }

                longestStreak = Math.max(longestStreak, currentStreak);
            }
        }
        return longestStreak;
    }
}
