package LeetCode.q287_寻找重复数;

/**
 * @Author: Young
 * @Date: 2025/12/12 10:48
 * <p>
 * 采用二分查找的方法   在每个区间内统计数量 如果数量大于正常的区间 说明重复数在该区间内
 */
public class Solution {
    public int findDuplicate(int[] nums) {
        int max = nums.length - 1;
        int min = 1;
        while (min < max) {
            int mid = min + (max -min)/2;
            // 计数
            int count = 0;
            for (int num : nums) {
                if (num >= min && num <= mid) {
                    count++;
                }
            }

            if (count > (mid - min + 1)) {
                // 重复数在左区间
                max = mid;
            } else {
                // 重复数在右区间
                min = mid + 1;
            }
            
        }
        return min;
    }
}
