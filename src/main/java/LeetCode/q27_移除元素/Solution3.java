package LeetCode.q27_移除元素;

/**
 * @author biyangyang79989@zto.com
 * @version 1.0
 * @date 2026-10-01
 */
public class Solution3 {
    public int removeElement(int[] nums, int val) {
        int n = nums.length;
        int slow = 0;
        for (int fast = 0; fast < n; fast++) {
            if (nums[fast] != val) {
                nums[slow] = nums[fast];
                slow++;
            }
        }
        return slow;
    }
}
