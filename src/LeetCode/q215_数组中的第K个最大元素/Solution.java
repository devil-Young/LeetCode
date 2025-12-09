package q215_数组中的第K个最大元素;

/**
 * @Author: Young
 * @Date: 2025/6/6 16:05
 * 方法一：基于快速排序的选择方法
 * 快排
 * 选择一个基准值（pivot）；
 * <p>
 * 将数组划分成两部分：左边是小于等于 pivot 的元素，右边是大于 pivot 的元素；
 * <p>
 * 递归地对两部分继续排序；
 * <p>
 * 最终拼接排序好的左半部分 + pivot + 右半部分即可。
 * <p>
 * 我们知道快速排序的性能和「划分」出的子数组的长度密切相关。直观地理解如果每次规模为 n 的问题我们都划分成 1 和 n−1，每次递归的时候又向 n−1 的集合中递归，这种情况是最坏的，时间代价是 O(n
 * 2
 * )。我们可以引入随机化来加速这个过程，它的时间代价的期望是 O(n)，证明过程可以参考「《算法导论》9.2：期望为线性的选择算法」。
 */
public class Solution {
    public int quickSelect(int[] nums, int l, int r, int k) {
        if (l == r) {
            return nums[k];
        }
        int x = nums[l], i = l - 1, j = r + 1;
        while (i < j) {
            do i++; while (nums[i] < x);
            do j--; while (nums[j] > x);
            if (i < j) {
                int tmp = nums[i];
                nums[i] = nums[j];
                nums[j] = tmp;
            }
        }
        if (k <= j) return quickSelect(nums, l, j, k);
        else return quickSelect(nums, j + 1, r, k);

    }

    public int findKthLargest(int[] nums, int k) {
        int n = nums.length;
        return quickSelect(nums, 0, n - 1, n - k);  //n - k 是因为：第 k 大等价于第 (n-k) 小（数组下标从 0 开始）。
    }
}
