package LeetCode.Q100_相同的树;

/**
 * @Author: Young
 * @Date: 2025/1/5 21:50
 * 方法一：深度优先搜索
 */
public class Solution {
    public boolean isSameTree(TreeNode p, TreeNode q) {
        if (p == null && q == null) {
            return true; // 两个节点都为空
        } else if (p == null || q == null) {
            return false;
        } else if (p.val != q.val) {
            return false; // 两个节点值不相等
        } else {
            return isSameTree(p.left, q.left) && isSameTree(p.right, q.right);
        }
    }
}
