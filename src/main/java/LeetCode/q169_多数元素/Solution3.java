package LeetCode.q169_多数元素;

import java.util.Random;

/**
 * @author biyangyang79989@zto.com
 * @version 1.0
 * @date 2026-10-04
 */
public class Solution3 {
    public int majorityElement(int[] nums) {
        Random rand = new Random();
        int majorityCount = nums.length / 2;
        while (true) {
            int candidate = nums[randRange(rand, 0, nums.length)];
            if (countOccurences(nums, candidate) > majorityCount) {
                return candidate;
            }
        }
    }

    private int randRange(Random rand, int min, int max) {
        return rand.nextInt(max - min) + min;
    }

    private int countOccurences(int[] nums, int num) {
        int count = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == num) {
                count++;
            }
        }
        return count;
    }
}
