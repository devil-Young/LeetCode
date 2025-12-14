package LeetCode.q189_轮转数组;

/**
 * @Author: Young
 * @Date: 2025/2/20 22:58
 * 方法一：使用额外的数组
 */
public class Solution {
    public void rotate(int[] nums, int k) {
        int n = nums.length;
        int[] newArr = new int[n];

        for (int i = 0; i < n; i++) {
            newArr[(i + k) % n] = nums[i];
        }

        System.arraycopy(newArr, 0, nums, 0, n);
    }
}
