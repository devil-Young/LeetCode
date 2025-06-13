package q240_搜索二维矩阵II;

/**
 * @Author: Young
 * @Date: 2025/6/13 14:55
 * <p>
 * 方法一：直接查找
 */
public class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        for (int[] row : matrix) {
            for (int element : row) {
                if (element == target) {
                    return true;
                }
            }
        }
        return false;
    }
}
