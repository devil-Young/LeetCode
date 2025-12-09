package q496_下一个更大元素I;

import java.util.*;
import java.util.stream.Collector;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

/**
 * @Author: Young
 * @Date: 2025/11/16 19:44
 */
public class Solution2 {
    public int[] nextGreaterElement(int[] nums1, int[] nums2) {
        int n = nums1.length;
        Map<Integer, Integer> idx = IntStream.range(0, n)
                .boxed()
                .collect(Collectors.toMap(i -> nums1[i], i -> i));

        int[] ans = new int[n];
        Arrays.fill(ans, -1);
        Deque<Integer> st = new ArrayDeque<>();

        for (int x : nums2) {
            while (!st.isEmpty() && x > st.peek()) {
                ans[idx.get(st.pop())] = x;
            }
            if (idx.containsKey(x)) { // x 在 nums1 中
                st.push(x); // 只需把在 nums1 中的元素入栈
            }

        }

        return ans;
    }
}
