package LeetCode.q54_螺旋矩阵;

import java.util.ArrayList;
import java.util.List;

/**
 * @Author: Young
 * @Date: 2024/4/26 23:31
 * 模拟螺旋矩阵的路径
 */
public class Solution {
    public List<Integer> spiralOrder(int[][] matrix) {
        ArrayList<Integer> order = new ArrayList<>();
        if (matrix == null || matrix.length == 0 || matrix[0].length == 0) {
            return order;
        }
        int rows = matrix.length, columns = matrix[0].length;
        boolean[][] visited = new boolean[rows][columns];
        int total = rows * columns;
        int row = 0, column = 0;
        int[][] directions = {{0, 1}, {1, 0}, {0, -1}, {-1, 0}}; // 方向数组
        int directionIndex = 0;
        for (int i = 0; i < total; i++) {
            order.add(matrix[row][column]);
            visited[row][column] = true;
            int nextRow = row + directions[directionIndex][0];
            int nextColumn = column + directions[directionIndex][1];
            // 检查下一个位置是否越界或已访问 掉头
            //visited[nextRow][nextColumn]放在最后 只会在行、列都合法时才访问数组，避免 ArrayIndexOutOfBoundsException。
            if (nextColumn >= columns || nextRow >= rows || nextColumn < 0 || nextRow < 0 || visited[nextRow][nextColumn]) {
                // 掉头
                directionIndex = (directionIndex + 1) % 4; // 顺时针转向
            }
            row += directions[directionIndex][0];
            column += directions[directionIndex][1];

        }
        return order;
    }
}
