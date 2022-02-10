package 两数之和;

import java.util.HashMap;
import java.util.Map;

/**
 * @author ：Young
 * @date ：Created in 2022/2/9 16:55
 */

public class Solution {

    public int[] twoSum(int[] nums, int target) {

        int n = nums.length;
        for (int i = 0; i < n; i++) {

            for (int j = i + 1; j < n; j++) {
                if (nums[i] + nums[j] == target) {
                    return new int[]{i, j};
                }

            }
        }

        return new int[0];

    }

    /**
     *  hash表
     */
    public int[] twoSum2(int[] nums, int target) {

        Map<Integer,Integer> hashMap = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {

            if (hashMap.containsKey(target-nums[i])){
                return new int[]{hashMap.get(target-nums[i]), i};
            }
            hashMap.put(nums[i], i);
        }

        return new int[0];

    }
}
