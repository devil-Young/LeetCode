package LeetCode.q240_搜索二维矩阵II;

/**
 * @Author: Young
 * @Date: 2025/6/13 15:18
 * <p>
 * 方法三：Z 字形查找
 * <p>
 * 从右上角出发，利用矩阵 行列都递增 的性质，进行“削行减列”：
 * <p>
 * 当前位置等于目标值，直接返回 true
 * <p>
 * 当前位置大于目标值，说明当前列下面的所有数都大于目标值，去掉当前列
 * <p>
 * 当前位置小于目标值，说明当前行左边的所有数都小于目标值，去掉当前行
 */
public class Solution3 {
    public boolean searchMatrix(int[][] matrix, int target) {
        int m = matrix.length, n = matrix[0].length;
        int x = 0, y = n - 1; // 从右上角开始
        while (x < m && y >= 0) {
            if (target == matrix[x][y]) {
                return true;
            }
            if (target < matrix[x][y]) {
                y--; // 当前列的所有数都大于目标值，去掉当前列
            } else {
                x++; // 当前行的所有数都小于目标值，去掉当前行
            }
        }
        return false; // 没有找到目标值
    }
}

