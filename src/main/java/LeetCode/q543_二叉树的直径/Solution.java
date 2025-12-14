package LeetCode.q543_二叉树的直径;

/**
 * @Author: Young
 * @Date: 2025/6/20 00:44
 */
public class Solution {
    int ans;
    public int diameterOfBinaryTree(TreeNode root) {
        ans = 1; // 初始化为1，因为直径至少包含一个节点
        depth(root);
        return  ans - 1;
    }

    public int depth(TreeNode root) {
        if (root == null) {
            return 0;
        }

        int L = depth(root.left);
        int R = depth(root.right);
        ans = Math.max(ans, L + R + 1); // 更新直径
        return Math.max(L, R) + 1; // 返回该节点为根的子树的深度
    }
}
