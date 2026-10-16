package LeetCode.q454_四数相加II;

import java.util.HashMap;

/**
 * @author biyangyang79989@zto.com
 * @version 1.0
 * @date 2026-10-16
 */
public class Solution {
    public int fourSumCount(int[] nums1, int[] nums2, int[] nums3, int[] nums4) {
        HashMap<Integer, Integer> countAB = new HashMap<>();
        for (int num : nums1) {
            for (int num2 : nums2) {
                countAB.put(num + num2, countAB.getOrDefault(num + num2, 0) + 1);
            }
        }

        int count = 0;
        for (int num3 : nums3) {
            for (int num4 : nums4) {
                count += countAB.getOrDefault(-(num3 + num4), 0);
            }
        }
        return count;
    }
}
