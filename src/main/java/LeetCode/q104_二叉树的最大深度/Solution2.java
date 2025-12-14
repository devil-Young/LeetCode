package LeetCode.q104_二叉树的最大深度;

import java.util.LinkedList;
import java.util.Queue;

/**
 * @Author: Young
 * @Date: 2025/6/19 18:15
 * 方法二：广度优先搜索
 */
public class Solution2 {
    public int maxDepth(TreeNode root) {
        if (root == null) return 0;

        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        int ans = 0;
        while (!queue.isEmpty()) {
            int size = queue.size();
            while (size > 0){
                TreeNode node = queue.poll();
                if (node.left != null) {
                    queue.offer(node.left);
                }
                if (node.right != null) {
                    queue.offer(node.right);
                }
                size--;
            }
            ans++;
        }
        return ans;
    }
}
