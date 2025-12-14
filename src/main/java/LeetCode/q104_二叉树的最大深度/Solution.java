package LeetCode.q104_二叉树的最大深度;

/**
 * @Author: Young
 * @Date: 2025/6/18 16:28
 * <p>
 * 方法一：深度优先搜索
 */
public class Solution {
    public int maxDepth(TreeNode root) {
        if (root == null) {
            return 0;
        } else {
            int leftHeight = maxDepth(root.left);
            int rightHeight = maxDepth(root.right);
            return Math.max(leftHeight, rightHeight) + 1;
        }
    }
}
