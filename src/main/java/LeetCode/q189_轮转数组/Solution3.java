package LeetCode.q189_轮转数组;

import java.rmi.server.RemoteServer;

/**
 * @Author: Young
 * @Date: 2025/5/29 22:05
 *
方法三：数组翻转 */
public class Solution3 {
    public void rotate(int[] nums, int k) {
        k %= nums.length;
        reverse(nums, 0, nums.length - 1);
        reverse(nums, 0, k-1);
        reverse(nums, k, nums.length - 1);

    }

    public void reverse(int[] nums, int start, int end) {
        while (start < end) {
            int temp = nums[start];
            nums [start] = nums[end];
            nums[end] = temp;
            start++;
            end--;
        }
    }
}
