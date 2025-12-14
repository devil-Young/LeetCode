package LeetCode.q114_二叉树展开为链表;

import java.util.ArrayList;
import java.util.List;

/**
 * @Author: Young
 * @Date: 2025/6/23 17:32
 * <p>
 * 方法一：前序遍历 迭代
 * 展开二叉树为链表的过程可以看作是对二叉树进行前序遍历。
 */
public class Solution {
    public void flatten(TreeNode root) {
        List<TreeNode> list = new ArrayList<>();
        preorderTraversal(root, list);
        int size = list.size();
        for (int i = 1; i < size; i++) {
            TreeNode prev = list.get(i - 1);
            TreeNode curr = list.get(i);
            prev.left = null; // 将左子树置为 null
            prev.right = curr; // 将右子树指向当前节点
        }

    }

    public void preorderTraversal(TreeNode root, List<TreeNode> list) {
        if (root != null) {
            list.add(root);
            preorderTraversal(root.left, list);
            preorderTraversal(root.right, list);
        }

    }
}
