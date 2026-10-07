package LeetCode.q349_两个数组的交集;

import java.util.HashSet;

/**
 * @author biyangyang79989@zto.com
 * @version 1.0
 * @date 2026-10-07
 */
public class Solution {
    public int[] intersection(int[] nums1, int[] nums2) {
        HashSet<Integer> set1 = new HashSet<>();
        for (int i = 0; i < nums1.length; i++) {
            set1.add(nums1[i]);
        }
        HashSet<Integer> set2 = new HashSet<>();
        for (int i = 0; i < nums2.length; i++) {
            if (set1.contains(nums2[i])){
                set2.add(nums2[i]);
            }
        }
        return set2.stream().mapToInt(Integer::intValue).toArray();
    }
}
