package q105_从前序与中序遍历序列构造二叉树;

/**
 * @Author: Young
 * @Date: 2025/6/25 00:01
 */


public class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;

    TreeNode() {
    }

    TreeNode(int val) {
        this.val = val;
    }

    TreeNode(int val, TreeNode left, TreeNode right) {
        this.val = val;
        this.left = left;
        this.right = right;
    }
}
