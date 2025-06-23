package q114_二叉树展开为链表;

import java.util.Deque;
import java.util.LinkedList;

/**
 * @Author: Young
 * @Date: 2025/6/24 02:50
 * <p>
 * 方法二：前序遍历和展开同步进行
 */
public class Solution3 {
    public void flatten(TreeNode root) {
        if (root == null) return;

        Deque<TreeNode> stack = new LinkedList<>();
        stack.push(root);
        TreeNode prev = null;
        while (!stack.isEmpty()) {
            TreeNode curr = stack.pop();
            if (prev != null){
                prev.left = null; // 将左子树置为 null
                prev.right = curr; // 将右子树指向当前节点
            }
            TreeNode left = curr.left, right = curr.right;
            if (right != null) {
                stack.push(right);
            }
            if (left != null) {
                stack.push(left);
            }
            prev = curr; // 更新前一个节点
        }
    }
}
