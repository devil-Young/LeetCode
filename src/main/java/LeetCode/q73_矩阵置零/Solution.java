package LeetCode.q73_矩阵置零;

/**
 * @Author: Young
 * @Date: 2025/6/13 00:44
 * 方法一：使用标记数组
 * <p>
 * 用两个标记数组分别记录每一行和每一列是否有零出现。
 */
public class Solution {
    public void setZeroes(int[][] matrix) {
        int m = matrix.length;
        int n = matrix[0].length;

        boolean[] row = new boolean[m];
        boolean[] col = new boolean[n];

        // 第一次遍历，记录每一行和每一列是否有零
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (matrix[i][j] == 0) {
                    row[i] = true;
                    col[j] = true;
                }
            }
        }

        // 第二次遍历，根据标记数组将对应的行和列置零
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (row[i] || col[j]) {
                    matrix[i][j] = 0;
                }
            }
        }
    }
}
