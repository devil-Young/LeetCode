package LeetCode.q144_二叉树的前序遍历;

import java.util.ArrayList;
import java.util.List;

/**
 * @Author: Young
 * @Date: 2025/6/24 00:11
 * <p>
 * 方法三：Morris 遍历
 */
public class Solution3 {
    public List<Integer> preorderTraversal(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        if (root == null) {
            return res;
        }
        TreeNode p1 = root, p2 = null;
        while (p1 != null) {
            p2 = p1.left;
            // 找到前驱节点 找前驱节点（左子树最右侧的点）
            if (p2 != null) {
                while (p2.right != null && p2.right != p1) {
                    p2 = p2.right;
                }

                if (p2.right == null) {
                    // 第一次到达这个节点：访问 + 建立线索
                    res.add(p1.val);
                    p2.right = p1; // 建立线索：让前驱的右指针指向当前节点
                    p1 = p1.left; // 继续遍历左子树
                    continue;
                } else {
                    // 第二次到达：已经处理完左子树了
                    p2.right = null; // 恢复树结构
                }
            } else {
                // 没有左子树，直接访问
                res.add(p1.val);
            }
            p1 = p1.right; // 继续遍历右子树
        }

        return res;
    }
}
