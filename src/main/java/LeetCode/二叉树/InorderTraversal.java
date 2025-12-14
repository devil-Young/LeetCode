package LeetCode.二叉树;

/**
 * @Author: Young
 * @Date: 2025/6/21 02:00
 * 二叉树中序遍历 循环
 */
import java.util.*;

class TreeNode {
    int val;
    TreeNode left, right;
    TreeNode(int val) { this.val = val; }
}

public class InorderTraversal {
    public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        Stack<TreeNode> stack = new Stack<>();

        TreeNode curr = root;

        while (curr != null || !stack.isEmpty()) {
            // 1. 一路往左，把所有左节点压栈
            while (curr != null) {
                stack.push(curr);
                curr = curr.left;
            }

            // 2. 左子树到底了，弹出栈顶访问节点
            curr = stack.pop();
            res.add(curr.val);  // 中序：在这里访问节点

            // 3. 准备遍历右子树
            curr = curr.right;
        }

        return res;
    }
}

