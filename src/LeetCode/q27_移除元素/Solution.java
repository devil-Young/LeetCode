package q27_移除元素;

/**
 * @Author: Young
 * @Date: 2023/9/25 22:03
 *
 * 双指针
 */
public class Solution {
    public int removeElement(int[] nums, int val) {
        int n = nums.length;
        int left = 0;
        for (int right = 0; right < n; right++) {
            if (nums[right] != val) {
                nums[left] = nums[right];
                left++;
            }
        }
        return left;
    }
}
