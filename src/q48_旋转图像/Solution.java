package q48_旋转图像;

/**
 * @Author: Young
 * @Date: 2023/12/24 00:46
 * 方法一：使用辅助数组
 * 1，2--> 倒数1列 第二行
 */
public class Solution {
    public void rotate(int[][] matrix) {
        int n = matrix.length;
        int[][] matrixNew = new int[n][n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                matrixNew[j][n - i -1] = matrix[i][j];
            }
        }
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                matrix[i][j] = matrixNew[i][j];
            }
        }
    }
}
