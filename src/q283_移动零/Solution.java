package q283_移动零;

/**
 * @Author: Young
 * @Date: 2025/2/7 22:36
 * 双指针
 */
public class Solution {
    public void moveZeroes(int[] nums) {
        int n = nums.length;
        int left = 0, right = 0;
        while (right < n) {
            if (nums[right] != 0) {
                int temp = nums[left];
                nums[left] = nums[right];
                nums[right] = temp;
                left++;
            }
            right++;
        }

    }
}
