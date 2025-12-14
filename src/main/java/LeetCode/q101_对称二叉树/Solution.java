package LeetCode.q101_对称二叉树;

/**
 * @Author: Young
 * @Date: 2025/6/19 22:52
 * <p>
 * 方法一：递归
 * <p>
 * 如果同时满足下面的条件，两个树互为镜像：
 * <p>
 * 它们的两个根结点具有相同的值
 * 每个树的右子树都与另一个树的左子树镜像对称
 */
public class Solution {
    public boolean isSymmetric(TreeNode root) {
        return check(root, root);
    }

    public boolean check(TreeNode p, TreeNode q) {
        if (p == null && q == null) {
            return true;
        }

        if (p == null || q == null) {
            return false;
        }

        return p.val == q.val && check(p.left, q.right) && check(p.right, q.left);
    }
}
