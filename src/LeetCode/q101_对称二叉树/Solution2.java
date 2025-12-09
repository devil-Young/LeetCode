package q101_对称二叉树;

import java.util.LinkedList;
import java.util.Queue;

/**
 * @Author: Young
 * @Date: 2025/6/19 23:24
 * <p>
 * 方法二：迭代
 */
public class Solution2 {
    public boolean isSymmetric(TreeNode root) {
        return check(root, root);
    }

    public boolean check(TreeNode u, TreeNode v) {
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(u);
        queue.offer(v);

        while (!queue.isEmpty()) {
            u = queue.poll();
            v = queue.poll();
            if (u == null && v == null) {
                continue;
            }
            if ((u == null || v == null) || (u.val != v.val)) {
                return false;
            }

            queue.offer(u.left);
            queue.offer(v.right);

            queue.offer(u.right);
            queue.offer(v.left);


        }
        return true;
    }
}
