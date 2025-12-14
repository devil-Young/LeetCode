package LeetCode.q48_旋转图像;

/**
 * @Author: Young
 * @Date: 2023/12/24 01:03
 * 方法二：原地旋转
 * 原位置 --> 旋转后索引位置
 * matrix[i][j] --> matrix[j][n-1-i]
 */
public class Solution2 {
    public void rotate(int[][] matrix) {
        int n = matrix.length;
        for (int i = 0; i < n / 2; i++) {
            for (int j = 0; j < (n + 1) / 2; j++) {
                int tmp = matrix[i][j];
                matrix[i][j] = matrix[n - 1 - j][i];
                matrix[n - 1 - j][i] = matrix[n - 1 - i][n - 1 -j];
                matrix[n - 1 - i][n - 1 - j] = matrix[j][n - 1 - i];
                matrix[j][n - 1 - i] = tmp;
            }
        }
    }
}
