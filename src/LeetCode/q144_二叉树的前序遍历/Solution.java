package q144_二叉树的前序遍历;

import java.util.ArrayList;
import java.util.List;

/**
 * @Author: Young
 * @Date: 2025/6/23 17:44
 * <p>
 * 方法一：递归
 */
public class Solution {
    public List<Integer> preorderTraversal(TreeNode root) {
        ArrayList<Integer> res = new ArrayList<>();
        preorder(root, res);
        return res;
    }

    private void preorder(TreeNode root, List<Integer> res) {
        if (root == null) {
            return;
        }
        res.add(root.val);
        preorder(root.left, res);
        preorder(root.right, res);
    }
}
