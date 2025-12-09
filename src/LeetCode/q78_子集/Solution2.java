package q78_子集;

import java.util.ArrayList;
import java.util.List;

/**
 * @Author: Young
 * @Date: 2025/10/26 01:13
 */
public class Solution2 {

    public List<List<Integer>> subsets(int[] nums){
        List<List<Integer>> res = new ArrayList<List<Integer>>();
        res.add(new ArrayList<Integer>());

        for (Integer n : nums) {
            int size = res.size();
            for (int i = 0; i < size; i++) {
                List<Integer> sub = new ArrayList<>(res.get(i));
                sub.add(n);
                res.add(sub);
            }
        }
        return res;
    }
}
