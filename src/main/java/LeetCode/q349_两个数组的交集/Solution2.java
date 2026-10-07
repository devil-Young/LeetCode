package LeetCode.q349_两个数组的交集;

import java.util.Arrays;
import java.util.Set;
import java.util.stream.Collectors;

/**
 * @author biyangyang79989@zto.com
 * @version 1.0
 * @date 2026-10-07
 */
public class Solution2 {
    public int[] intersection(int[] nums1, int[] nums2) {
        Set<Integer> set1 = Arrays.stream(nums1).boxed().collect(Collectors.toSet());
        return Arrays.stream(nums2).filter(set1::remove).toArray();
    }
}
