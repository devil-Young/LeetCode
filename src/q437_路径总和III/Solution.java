package q437_路径总和III;

/**
 * @Author: Young
 * @Date: 2025/6/25 14:40
 * <p>
 * 方法一：深度优先搜索
 */
public class Solution {
    public int pathSum(TreeNode root, int targetSum) {
        if (root == null) return 0;

        int ret = rootSum(root, targetSum);
        ret += pathSum(root.left, targetSum);
        ret += pathSum(root.right, targetSum);

        return ret;

    }

    public int rootSum(TreeNode root, long targetSum) {
        int res = 0;
        if (root == null) return 0;
        int val = root.val;

        if (val == targetSum) {
            res++;
        }

        res += rootSum(root.left, targetSum - val);
        res += rootSum(root.right, targetSum - val);

        return res;
    }
}
