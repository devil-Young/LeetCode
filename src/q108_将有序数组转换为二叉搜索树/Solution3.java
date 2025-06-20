package q108_将有序数组转换为二叉搜索树;

import java.util.Random;

/**
 * @Author: Young
 * @Date: 2025/6/21 01:21
 * 方法三：中序遍历，选择任意一个中间位置数字作为根节点
 */
class Solution3 {
    Random rand = new Random();

    public TreeNode sortedArrayToBST(int[] nums) {
        return helper(nums, 0, nums.length - 1);
    }

    public TreeNode helper(int[] nums, int left, int right) {
        if (left > right) {
            return null;
        }

        // 选择任意一个中间位置数字作为根节点
        int mid = (left + right + rand.nextInt(2)) / 2;

        TreeNode root = new TreeNode(nums[mid]);
        root.left = helper(nums, left, mid - 1);
        root.right = helper(nums, mid + 1, right);
        return root;
    }
}

