package LeetCode.q94_二叉树的中序遍历;

/**
 * @Author: Young
 * @Date: 2025/1/5 21:52
 */
public class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode() {}
    TreeNode(int val) { this.val = val; }
    TreeNode(int val, TreeNode left, TreeNode right) {
        this.val = val;
        this.left = left;
        this.right = right;
    }
}
