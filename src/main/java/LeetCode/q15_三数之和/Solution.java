package LeetCode.q15_三数之和;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @Author: Young
 * @Date: 2023/9/9 23:28
 *
 * 排序 + 双指针
 */
public class Solution {
    public List<List<Integer>> threeSum(int[] nums){
        int n = nums.length;
        Arrays.sort(nums);
        List<List<Integer>> ans = new ArrayList<>();
        // (a, b, c)
        //枚举 a
        for (int first = 0; first < n; first++) {
            // 和上一次的循环值不同
            if (first > 0 && nums[first] == nums[first - 1]){
                continue;
            }
            // c的值开始指向数组的最右端
            int third = n - 1;
            int target = -nums[first];
            // 枚举b
            for (int second = first + 1; second <n; second++) {
                if (second > first + 1 && nums[second] == nums[second - 1]){
                    continue;
                }
                // 同时b的指针要在c的左侧
                while (second < third && nums[second] + nums[third] > target){
                    --third;
                }
                // 如果指针重合，随着 b 后续的增加 就不会有满足 a+b+c=0 并且 b<c 的 c 了
                if (second == third){
                    break;
                }
                if (nums[second] + nums[third] == target){
                    List<Integer> list = new ArrayList<>();
                    list.add(nums[first]);
                    list.add(nums[second]);
                    list.add(nums[third]);
                    ans.add(list);
                }
            }
        }
        return ans;
    }
}
