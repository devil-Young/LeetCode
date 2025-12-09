package q144_二叉树的前序遍历;

import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

/**
 * @Author: Young
 * @Date: 2025/6/23 23:45
 * <p>
 * 方法二：迭代
 */
public class Solution2 {
    public List<Integer> preorderTraversal(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        if (root == null) return res;

        Deque<TreeNode> stack = new LinkedList<>();
        TreeNode node = root;
        while (!stack.isEmpty() || node != null) {
            while (node != null) {
                res.add(node.val); // 访问当前节点
                stack.push(node);
                node = node.left;
            }
            node = stack.pop();
            node = node.right; // 访问完左子树后，转向右子树
        }

        return res;
    }

    }