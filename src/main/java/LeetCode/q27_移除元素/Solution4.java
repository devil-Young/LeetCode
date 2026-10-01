package LeetCode.q27_移除元素;

/**
 * @author biyangyang79989@zto.com
 * @version 1.0
 * @date 2026-10-01
 */
// 双指针优化
public class Solution4 {
    public int removeElement(int[] nums, int val) {
        int left = 0;
        int right = nums.length;

        while (left < right) {
            if (nums[left] != val) {
                left++;
            } else {
                nums[left] = nums[right - 1];
                right--;
            }
        }
        return left;
    }
}
