package LeetCode.q34_在排序数组中查找元素的第一个和最后一个位置;

/**
 * @Author: Young
 * @Date: 2023/12/24 19:33
 *
 * 二分查找中，寻找 leftIdx 即为在数组中寻找第一个大于等于 target的下标，
 * 寻找 rightIdx即为在数组中寻找第一个大于 target的下标，然后将下标减一。
 * 两者的判断条件不同，为了代码的复用，我们定义 binarySearch(nums, target, lower)
 * 表示在 nums\数组中二分查找 target的位置，
 * 如果 lower 为 true
 * 则查找第一个大于等于 target的下标，否则查找第一个大于 target的下标
 *
 */
public class Solution {
    public int[] searchRange(int[] nums, int target) {
        int leftIdx = binarySearch(nums, target, true);
        int rightIdx = binarySearch(nums, target, false) - 1;
        // 如果数组为空，或者所有数都 < target，则返回 nums.length
        if (leftIdx <= rightIdx && rightIdx < nums.length && nums[leftIdx] == target && nums[rightIdx] == target) {
            return new int[]{leftIdx,rightIdx};
        }
        return new int[]{-1, -1};
    }

    private int binarySearch(int[] nums, int target, boolean lower) {
        int left = 0, right = nums.length - 1, ans = nums.length;
        while (left <= right) {
            int mid = ((right - left) >> 1) + left;
            if (nums[mid] > target || (lower && nums[mid] >= target)) {
                right = mid - 1;
                ans = mid;
            } else {
                left = mid + 1;
            }
        }
        return ans;
    }
}
