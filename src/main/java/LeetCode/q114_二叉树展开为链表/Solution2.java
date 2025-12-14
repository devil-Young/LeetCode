package LeetCode.q114_二叉树展开为链表;

import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

/**
 * @Author: Young
 * @Date: 2025/6/24 02:29
 * <p>
 * 迭代实现前序遍历
 */
public class Solution2 {
    public void flatten(TreeNode root) {
        List<TreeNode> list = new ArrayList<>();
        Deque<TreeNode> stack = new LinkedList<>();
        TreeNode node = root;
        while (!stack.isEmpty() || node != null) {
            while (node != null) {
                list.add(node);
                stack.push(node);
                node = node.left; // 先遍历左子树
            }
            node = stack.pop();
            node = node.right; // 再遍历右子树

        }
        int size = list.size();
        for (int i = 1; i < size; i++) {
            TreeNode prev = list.get(i - 1), curr = list.get(i);
            prev.left = null;
            prev.right = curr;
        }

    }
}
