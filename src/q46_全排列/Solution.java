package q46_全排列;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * @Author: Young
 * @Date: 2023/12/24 12:30
 * 回朔法
 */
public class Solution {
    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> res = new ArrayList<List<Integer>>();
        List<Integer> output = new ArrayList<Integer>();
        for (int num : nums) {
            output.add(num);
        }

        int n = nums.length;
        backtrack(n, output, res, 0);
        return res;
    }

    private void backtrack(int n, List<Integer> output, List<List<Integer>> res, int first) {
        // n个数使用完 递归退出条件
        if (first == n) {
            res.add(new ArrayList<Integer>(output));
        }
        for (int i = first; i < n; i++) {
            // 动态维护数组
            Collections.swap(output, first, i);
            // 递归下一个数
            backtrack(n, output, res, first + 1);
            // 回溯后 撤销操作
            Collections.swap(output, first, i);
        }

    }
}
