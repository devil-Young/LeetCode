package 牛客.山峰间的极限跳跃;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

/**
 * @Author: Young
 * @Date: 2025/11/6 00:10
 */
public class Solution {

    static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int val) {
            this.val = val;
        }
    }

    static int k;
    static int maxLen = 0;

    static void main() {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        k = scanner.nextInt();

        if (n == 0) {
            System.out.println(0);
            return;
        }

        int[][] inputData = new int[n][3];
        HashMap<Integer, int[]> nodeInfo = new HashMap<>();

        for (int i = 0; i < n; i++) {
            int p = scanner.nextInt();
            int l = scanner.nextInt();
            int r = scanner.nextInt();
            inputData[i][0] = p;
            inputData[i][1] = l;
            inputData[i][2] = r;
            nodeInfo.put(p, new int[]{l, r});

        }

        // 构造树
        HashMap<Integer, TreeNode> nodes = new HashMap<>();
        nodes.put(-1, null);
        for (int p : nodeInfo.keySet()) {
            nodes.put(p, new TreeNode(p));
        }

        for (Map.Entry<Integer, int[]> entry : nodeInfo.entrySet()) {
            int p = entry.getKey();
            int[] children = entry.getValue();
            TreeNode parentNode = nodes.get(p);
            parentNode.left = nodes.get(children[0]);
            parentNode.right = nodes.get(children[1]);
        }

        TreeNode root = nodes.get(inputData[0][0]);

        dfs(root);

        System.out.println(maxLen);

    }

    // 返回一个大小为2的数组: {longest_up, longest_down}
    private static int[] dfs(TreeNode node) {
        if (node == null) {
            return new int[]{0, 0};
        }

        int longestUp = 1; // 先涨
        int longestDown = 1; // 先跌

        if (node.left != null) {
            int[] leftResult = dfs(node.left);
            if (Math.abs(node.val - node.left.val) >= k) {
                if (node.left.val > node.val) { // 向上
                    longestUp = Math.max(longestUp, 1 + leftResult[1]);
                } else { // 向下
                    longestDown = Math.max(longestDown, 1 + leftResult[0]);
                }

            }

            // 处理右子树
            if (node.right != null) {
                int[] rightRes = dfs(node.right);
                if (Math.abs(node.val - node.right.val) >= k) {
                    if (node.right.val > node.val) { // 向上
                        longestUp = Math.max(longestUp, 1 + rightRes[1]);
                    } else { // 向下
                        longestDown = Math.max(longestDown, 1 + rightRes[0]);
                    }
                }
            }

        }
        maxLen = Math.max(maxLen, Math.max(longestUp, longestDown));
        return new int[]{longestUp, longestDown};

    }
}
