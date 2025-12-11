package LeetCode.q4_寻找两个正序数组的中位数;

/**
 * @author ：Young
 * @date ：Created in 2022/2/11 22:13
 *
 * 题目要求时间复杂度 O(log (m+n))
 *
 * 一、使用归并的方式，合并两个有序数组，得到一个大的有序数组。
 * 大的有序数组的中间位置的元素，即为中位数。
 * 二、不需要合并两个有序数组，只要找到中位数的位置即可。
 * 由于两个数组的长度已知，因此中位数对应的两个数组的下标之和也是已知的。
 * 维护两个指针，初始时分别指向两个数组的下标 0 的位置，
 * 每次将指向较小值的指针后移一位（如果一个指针已经到达数组末尾，
 * 则只需要移动另一个数组的指针），直到到达中位数的位置。

 * 假设两个有序数组的长度分别为 m 和 n，
 * 一、思路的时间复杂度是O(m+n)，空间复杂度是 O(m+n)。
 * 二、思路虽然可以将空间复杂度降到 O(1)，但是时间复杂度仍是 O(m+n)。
 *
 */

public class Solution {

    /**
     * 归并的方式，合并两个有序数组，得到一个大的有序数组
     * 时间复杂度是O(m+n)，空间复杂度是 O(m+n)
     */
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {

        int m = nums1.length;
        int n = nums2.length;
        int[] nums = new int[m + n];

        int count = 0;
        int i = 0, j = 0;

        while (count != (m + n)) {
            // m为数组长度 最后一个索引是m-1
            if (i == m) {
                while (j != n) {
                    nums[count++] = nums2[j++];
                }
                break;
            }

            if (j == n) {
                while (i != m) {
                    nums[count++] = nums1[i++];
                }
                break;
            }

            if (nums1[i] < nums2[j]) {
                nums[count++] = nums1[i++];
            } else {
                nums[count++] = nums2[j++];
            }

        }

        if (count % 2 == 0) {
            return (nums[count / 2 - 1] + nums[count / 2]) / 2.0;
        } else {
            return nums[count / 2];
        }
    }

    /**
     * 不需要合并两个有序数组，只要找到中位数的位置即可
     * 空间复杂度降到 O(1)，但是时间复杂度仍是 O(m+n)
     */
    public double findMedianSortedArrays2(int[] nums1, int[] nums2) {
        int m = nums1.length;
        int n = nums2.length;
        int len = m + n;
        // 记录当前遍历的前后值
        int left = -1, right = -1;
        // 记录数据遍历到的位置
        int n1Start = 0, n2Start = 0;

        // 中位数位置
        for (int i = 0; i <= len / 2; i++) {

            left = right;

            // 合并了半段条件  加入了 n2Start >= n
            if (n1Start < m && (n2Start >= n || nums1[n1Start] < nums2[n2Start])) {
                right = nums1[n1Start++];
            } else {
                right = nums2[n2Start++];
            }
        }
        if ((len & 1) == 0) {
            return (left + right) / 2.0;
        } else {
            return right;
        }

    }

}
