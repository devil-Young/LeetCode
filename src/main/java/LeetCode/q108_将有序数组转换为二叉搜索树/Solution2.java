package LeetCode.q108_将有序数组转换为二叉搜索树;

/**
 * @Author: Young
 * @Date: 2025/6/21 01:18
 *
 * 方法二：中序遍历，总是选择中间位置右边的数字作为根节点
 */
public class Solution2 {
    public TreeNode sortedArrayToBST(int[] nums) {
        return helper(nums, 0, nums.length - 1);
    }

    public TreeNode helper(int[] nums, int left, int right) {
        if (left > right) {
            return null;
        }

        // 总是选择中间位置右边的数字作为根节点
        int mid = (left + right + 1) / 2;

        TreeNode root = new TreeNode(nums[mid]);
        root.left = helper(nums, left, mid - 1);
        root.right = helper(nums, mid + 1, right);
        return root;
    }
}
