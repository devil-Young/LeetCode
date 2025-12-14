package LeetCode.q54_螺旋矩阵;

import java.util.ArrayList;
import java.util.List;

/**
 * @Author: Young
 * @Date: 2025/6/10 17:00
 * <p>
 * 方法二：按层模拟
 */
public class Solution2 {
    public List<Integer> spiralOrder(int[][] matrix) {
        List<Integer> order = new ArrayList<>();

        if (matrix == null || matrix.length == 0 || matrix[0].length == 0) return order;
        int rows = matrix.length;
        int columns = matrix[0].length;
        int left = 0, right = columns - 1, top = 0, bottom = rows - 1;
        while (left <= right && top <= bottom) {
            // 从左到右
            for (int column = left; column <= right; column++) {
                order.add(matrix[top][column]);
            }

            // 从上到下
            for (int row = top + 1; row <= bottom; row++) {
                order.add(matrix[row][right]);
            }
            // 如果还有行剩余，从右到左
            if (left < right && top < bottom) {
                for (int column = right - 1; column > left; column--) {
                    order.add(matrix[bottom][column]);
                }
                for (int row = bottom; row > top; row--) {
                    order.add(matrix[row][left]);
                }
            }
            left++;
            right--;
            top++;
            bottom--;
        }
        return order;
    }


}


