package q437_路径总和III;

import java.util.HashMap;
import java.util.Map;

/**
 * @Author: Young
 * @Date: 2025/6/25 19:44
 * <p>
 * 方法二: 前缀和
 */
public class Solution3 {
    public int pathSum(TreeNode root, int targetSum) {
        HashMap<Long, Integer> prefix = new HashMap<>();
        prefix.put(0L, 1); // 前缀和为 0 的路径数量为 1（空路径）
        return dfs(root, prefix, 0L, targetSum);
    }

    private int dfs(TreeNode root, Map<Long, Integer> prefix, Long curr, int targetSum) {
        if (root == null) return 0;

        int ret = 0;
        curr += root.val;

        ret = prefix.getOrDefault(curr - targetSum, 0);
        //记录当前前缀和
        prefix.put(curr, prefix.getOrDefault(curr, 0) + 1);
        ret += dfs(root.left, prefix, curr, targetSum);
        ret += dfs(root.right, prefix, curr, targetSum);
        prefix.put(curr, prefix.getOrDefault(curr, 0) - 1);

        return ret;

    }

}

