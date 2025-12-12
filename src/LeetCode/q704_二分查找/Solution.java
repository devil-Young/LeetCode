package LeetCode.q704_二分查找;

/**
 * @Author: Young
 * @Date: 2025/12/12 11:36
 */
public class Solution {
    public int search(int[] nums, int target) {
        int left = 0;
        int right = nums.length - 1;

        while (left <= right) {
            int mid  = left + (right - left) / 2;
            if (nums[mid] == target) {
                return mid;
            }else if (nums[mid] > target) {
                right = mid - 1;
            }else  {
                left = mid + 1;
            }
        }
        return -1;
    }
}
