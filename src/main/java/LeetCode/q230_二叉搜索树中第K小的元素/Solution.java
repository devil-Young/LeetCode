package LeetCode.q230_二叉搜索树中第K小的元素;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * @Author: Young
 * @Date: 2025/6/21 01:40
 * <p>
 * 方法一：中序遍历
 */
public class Solution {
    public int kthSmallest(TreeNode root, int k) {
        Deque<TreeNode> stack = new ArrayDeque<TreeNode>();

        while (root != null || !stack.isEmpty()) {
            while (root != null) {
                stack.push(root);
                root = root.left; // 一直向左走
            }
            root = stack.pop(); // 弹出栈顶元素
            --k; // 访问当前节点，k 减一
            if (k == 0) break;
            root = root.right; // 访问完左子树后，转向右子树

        }
        return root.val;
    }
}
