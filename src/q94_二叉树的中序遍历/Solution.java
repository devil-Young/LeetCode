package q94_二叉树的中序遍历;

import java.util.ArrayList;
import java.util.List;

/**
 * @Author: Young
 * @Date: 2025/1/6 22:37
 * 递归
 */
public class Solution {
    public List<Integer> inorderTraversal(TreeNode root) {
        ArrayList<Integer> res = new ArrayList<>();
        inorder(root, res);
        return res;
    }

    private void inorder(TreeNode root, List<Integer> res) {
        if (root == null) {
            return;
        }
        inorder(root.left, res);
        res.add(root.val);
        inorder(root.right, res);
    }
}
