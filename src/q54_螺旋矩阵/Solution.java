package q54_螺旋矩阵;

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
        int [][] directions = {{1, 0}, {-1, 0}, {0, 1}, {0, -1}};
        int directionIndex = 0;
        for (int i = 0; i < total; i++) {
            order.add(matrix[row][column]);
            visited[row][column] = true;
            int newRow = row + directions[directionIndex][0];
        }
    }
}
