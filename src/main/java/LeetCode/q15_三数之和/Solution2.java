package LeetCode.q15_三数之和;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author biyangyang79989@zto.com
 * @version 1.0
 * @date 2026-10-21
 */
public class Solution2 {
    public List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> ans = new ArrayList<>();
        Arrays.sort(nums);
        int len = nums.length;
        if (len < 3) return ans;
        for (int i = 0; i < len; i++) {
            if (nums[i] > 0) break;
            // a b c  a去重
            if (i > 0 && nums[i] == nums[i - 1]) continue;
            int left = i + 1;
            int right = len - 1;
            while (left < right) {
                int sum = nums[i] + nums[left] + nums[right];
                if (sum == 0) {
                    ans.add(Arrays.asList(nums[i], nums[left], nums[right]));
                    // b去重
                    while (left < right && nums[left] == nums[left + 1]) left++;
                    // c去重
                    while (left < right && nums[right] == nums[right - 1]) right--;
                    left++;
                    right--;
                } else if (sum < 0) {
                    left++;
                } else {
                    right--;
                }
            }
        }
        return ans;
    }
}
