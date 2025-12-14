package LeetCode.q496_下一个更大元素I;

/**
 * @Author: Young
 * @Date: 2025/11/16 19:26
 */
public class Solution {
    public int[] nextGreaterElement(int[] nums1, int[] nums2) {
        int m = nums1.length;
        int n = nums2.length;
        int[] res = new int[m];

        for (int i = 0; i < m; i++) {
            int j = 0;
            while (j < n && nums2[j] != nums1[i]) {
                j++;
            }
            int k = j + 1;
            while (k < n && nums2[k] <= nums1[i]) {
                k++;
            }
            res[i] = (k < n) ? nums2[k] : -1;
        }
        return res;
    }
}
