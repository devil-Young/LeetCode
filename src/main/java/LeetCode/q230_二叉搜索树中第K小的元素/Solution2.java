package LeetCode.q230_二叉搜索树中第K小的元素;

import java.util.HashMap;
import java.util.Map;

/**
 * @Author: Young
 * @Date: 2025/6/21 18:18
 * <p>
 * 如果你需要频繁地查找第 k 小的值，如何优化算法
 */
public class Solution2 {
    public int kthSmallest(TreeNode root, int k) {
        MyBst bst = new MyBst(root);
        return bst.kthSmallest(k);
    }
}

class MyBst {
    TreeNode root;
    Map<TreeNode, Integer> nodeNum;

    public MyBst(TreeNode root) {
        this.root = root;
        this.nodeNum = new HashMap<TreeNode, Integer>(); // 这里可以初始化一个 Map 来存储每个节点的子树大小
        countNodeNum(root);
    }

    // 返回二叉搜索树中第k小的元素
    public int kthSmallest(int k) {
        TreeNode node = root;
        while (node != null) {
            int left = getNodeNum(node.left);
            if (left < k - 1) {
                node = node.right;
                k -= left + 1; // 减去左子树的结点数和当前结点
            } else if (left == k - 1) {
                break;
            } else {
                node = node.left;
            }
        }
        return node.val;
    }

    // 统计以node为根结点的子树的结点数
    private int countNodeNum(TreeNode node) {
        if (node == null) return 0;
        nodeNum.put(node, countNodeNum(node.left) + countNodeNum(node.right) + 1);
        return nodeNum.get(node);
    }

    // 获取以node为根结点的子树的结点数
    private int getNodeNum(TreeNode node) {
        return nodeNum.getOrDefault(node, 0);
    }

}
