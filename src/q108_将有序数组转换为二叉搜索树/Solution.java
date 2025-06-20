package q108_将有序数组转换为二叉搜索树;

/**
 * @Author: Young
 * @Date: 2025/6/20 20:55
 * <p>
 * 方法一：中序遍历，总是选择中间位置左边的数字作为根节点
 */
public class Solution {
    public TreeNode sortedArrayToBST(int[] nums) {
        return helper(nums, 0, nums.length - 1);
    }

    public TreeNode helper(int[] nums, int left, int right) {
        if (left > right) {
            return null; // 递归终止条件
        }
        int mid = (left + right) / 2; // 选择中间位置的数字作为根节点
        TreeNode root = new TreeNode(nums[mid]);
        root.left = helper(nums, left, mid - 1); // 递归构建左子树
        root.right = helper(nums, mid + 1, right); // 递归构建右子树
        return root;
    }
}