package q16_最接近的三数之和;

import java.util.Arrays;

/**
 * @Author: Young
 * @Date: 2023/9/16 22:40
 */
public class Solution {
    public int threeSumClosest(int[] nums, int target){
        Arrays.sort(nums);
        int n = nums.length;
        int best = 10000000;

        // 枚举a的值
        for (int i = 0; i < n; i++) {
            if (i > 0 && nums[i] == nums[i - 1]){
                continue;
            }
            // 双指针枚举排序后的数组 b,c的值
            int j = i + 1, k = n - 1;
            while (j < k){
                int sum = nums[i] + nums[j] + nums[k];
                if (sum == target){
                    return target;
                }
                // 根据差值的绝对值更新
                if (Math.abs(sum - target) < Math.abs(best - target)){
                    best = sum;
                }
                if (sum > target){
                    // 如果和大于 target，移动 c 对应的指针
                    int k0 = k -1;
                    // 移动到下一个不相等的元素
                    while (j < k0 && nums[k0] == nums[k]){
                        k0--;
                    }
                    k = k0;
                }else {
                    // 如果和小于 target，移动 b 对应的指针
                    int j0 = j + 1;
                    // 移动到下一个不相等的元素
                    while (j0 < k && nums[j0] == nums[j]) {
                        ++j0;
                    }
                    j = j0;
                }
            }
        }
        return best;
    }
}
