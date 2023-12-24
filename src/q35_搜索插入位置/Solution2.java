package q35_搜索插入位置;

/**
 * @Author: Young
 * @Date: 2023/12/24 19:22
 *
 */
public class Solution2 {
    public int searchInsert(int[] nums, int target) {
        int n = nums.length;
        int left = 0, right = n - 1;
        while (left <= right) {
            int mid = ((right - left) >> 1) + left;
             if (nums[mid] < target) {
                left = mid + 1;
            }else {
                right = mid - 1;
            }
        }
        return left;
    }
}
