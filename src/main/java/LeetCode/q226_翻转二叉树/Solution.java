package LeetCode.q226_翻转二叉树;

/**
 * @Author: Young
 * @Date: 2025/6/19 22:37
 */
public class Solution {
    public TreeNode invertTree(TreeNode root) {
        if (root == null){
            return  null;
        }

        TreeNode left = invertTree(root.left);
        TreeNode right = invertTree(root.right);
        root.left = right;
        root.right = left;
        return root;
    }
}
