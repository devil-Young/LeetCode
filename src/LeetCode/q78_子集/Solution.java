package q78_子集;

import java.util.ArrayList;
import java.util.List;

/**
 * @Author: Young
 * @Date: 2025/10/26 00:30
 */
public class Solution {
    public List<List<Integer>> subsets(int[] nums) {
        ArrayList<List<Integer>> res = new ArrayList<>();

        for (int i = 0; i < (1 << nums.length); i++) {
            ArrayList<Integer> sub = new ArrayList<>();
            for (int j = 0; j < nums.length; j++) {
                if ((i & (1 << j)) != 0) {
                    sub.add(nums[j]);
                }
            }
            res.add(sub);
        }
        return res;

    }
}
