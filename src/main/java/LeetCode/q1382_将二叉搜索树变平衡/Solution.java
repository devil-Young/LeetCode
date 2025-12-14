package LeetCode.q1382_将二叉搜索树变平衡;

import java.util.ArrayList;
import java.util.List;

/**
 * @Author: Young
 * @Date: 2025/6/20 22:10
 * <p>
 * 贪心构造
 * <p>
 * 平衡」要求它是一棵空树或它的左右两个子树的高度差的绝对值不超过 1，这很容易让我们产生这样的想法——左右子树的大小越「平均」，这棵树会不会越平衡？于是一种贪心策略的雏形就形成了：我们可以通过中序遍历将原来的二叉搜索树转化为一个有序序列，然后对这个有序序列递归建树，对于区间 [L,R]：
 * <p>
 * 取 mid=⌊
 * 2
 * L+R
 * ​
 * ⌋ ，即中心位置作为当前节点的值；
 * <p>
 * 如果 L≤mid−1，那么递归地将区间 [L,mid−1] 作为当前节点的左子树；
 * <p>
 * 如果 mid+1≤R，那么递归地将区间 [mid+1,R] 作为当前节点的右子树。
 */
public class Solution {
    List<Integer> inorderSeq = new ArrayList<Integer>();

    public TreeNode balanceBST(TreeNode root) {
        // 通过中序遍历将原来的二叉搜索树转化为一个有序序列
        getInorder(root);
        return build(0, inorderSeq.size() - 1);
    }

    public void getInorder(TreeNode o) {
        // 中序遍历
        if (o.left != null) getInorder(o.left);
        inorderSeq.add(o.val);
        if (o.right != null) getInorder(o.right);
    }

    public TreeNode build(int l, int r) {
        int mid = (l + r) >> 1;
        TreeNode node = new TreeNode(inorderSeq.get(mid));
        if (l <= mid -1) {
            node.left = build(l, mid - 1);
        }
        if (r >= mid + 1) {
            node.right = build(mid + 1, r);
        }
        return node;
    }
}
