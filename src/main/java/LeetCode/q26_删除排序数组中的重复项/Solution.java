package LeetCode.q26_删除排序数组中的重复项;

/**
 * @Author: Young
 * @Date: 2023/9/25 21:32
 *
 * 双指针
 */
public class Solution {
    public int removeDuplicates(int[] nums) {
        int n = nums.length;
        if (n == 0) {
            return 0;
        }
        int fast = 1, slow = 1;
        while (fast < n) {
            if (nums[fast] != nums[fast - 1]) {
                nums[slow]  = nums[fast];
                slow++;
            }
            fast++;
        }
        return slow;
    }
}
