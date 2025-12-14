package LeetCode.q6_Z字形变换;

/**
 * 2022年4月7日14:34:14
 */
public class Solution {
    public String convert(String s, int numRows) {
        int n = s.length();
        if (numRows == 1 || numRows >= n) {
            return s;
        }
        // 变换的周期
        int t = 2 * numRows - 2;
        // 矩阵的列数
        int c = (n + t - 1) / t * (numRows - 1);
        char[][] mat = new char[numRows][c];
        for (int i = 0, x = 0, y = 0; i < n; i++) {
            mat[x][y] = s.charAt(i);
            if (i % t < numRows - 1) {
                x++;
            } else {
                x--;
                y++;
            }
        }

        StringBuffer res = new StringBuffer();
        for (char[] row : mat) {
            for (char ch : row) {
                if (ch != 0) {
                    res.append(ch);
                }
            }
        }
        return res.toString();
    }

    public String convert2(String s, int numRows) {
        int n = s.length();
        if (numRows == 1 || numRows >= n) {
            return s;
        }
        StringBuffer[] mat = new StringBuffer[numRows];
        for (int i = 0; i < numRows; i++) {
            mat[i] = new StringBuffer();
        }

        for (int i = 0, x = 0, t = numRows * 2 - 2; i < n; i++) {
            mat[x].append(s.charAt(i));
            if (i % t < numRows - 1) {
                ++x;
            } else {
                --x;
            }
        }
        StringBuffer res = new StringBuffer();
        for (StringBuffer row : mat) {
            res.append(row);
        }

        return res.toString();
    }
}
