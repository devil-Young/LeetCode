package q114_二叉树展开为链表;

/**
 * @Author: Young
 * @Date: 2025/6/24 03:09
 * <p>
 * 方法三：寻找前驱节点
 */
public class Solution4 {
    public void flatten(TreeNode root) {
        TreeNode cur = root;
        while (cur != null) {
            if (cur.left != null) {
                TreeNode next = cur.left;
                TreeNode predecessor = next;
                while (predecessor.right != null) {
                    predecessor = predecessor.right; // 找到左子树的最右节点
                }
                predecessor.right = cur.right; // 将右子树连接到左子树的最右节点
                cur.left = null;
                cur.right = next; // 将左子树变为右子树
            }
            cur = cur.right;
        }
    }
}
