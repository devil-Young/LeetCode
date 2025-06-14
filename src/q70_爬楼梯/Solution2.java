package q70_爬楼梯;

/**
 * @Author: Young
 * @Date: 2025/6/3 15:36
 * <p>
 * 方法二：矩阵快速幂
 */
public class Solution2 {
    public int climbStairs(int n) {
        int[][] matrix = {{1, 1}, {1, 0}};
        int[][] res = pow(matrix, n);
        return res[0][0];
    }

    public int[][] pow(int[][] a, int n) {
        int[][] ret = {{1, 0}, {0, 1}};
        while (n > 0) {
            if ((n & 1) == 1) {
                ret = multiply(ret, a);
            }
            n >>= 1;
            a = multiply(a, a);
        }
        return ret;
    }

    public int[][] multiply(int[][] a, int[][] b) {
        int[][] c = new int[2][2];
        for (int i = 0; i < 2; i++) {
            for (int j = 0; j < 2; j++) {
                c[i][j] = a[i][0] * b[0][j] + a[i][1] * b[1][j];
            }
        }
        return c;
    }
}
