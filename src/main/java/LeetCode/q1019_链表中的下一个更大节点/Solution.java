package LeetCode.q1019_链表中的下一个更大节点;

import java.util.ArrayDeque;
import java.util.ArrayList;

/**
 * @Author: Young
 * @Date: 2025/11/16 18:20
 */
public class Solution {

    public int[] nextLargerNodes(ListNode head) {
        ArrayList<Integer> vals = new ArrayList<>();

        for (ListNode node = head; node != null; node = node.next) {
            vals.add(node.val);
        }

        int n = vals.size();
        int[] ans = new int[n];

        ArrayDeque<Integer> stack = new ArrayDeque<>();

        for (int i = 0; i < n; i++) {
            int curVal = vals.get(i);
            while (!stack.isEmpty() && vals.get(stack.peek()) < curVal) {
                ans[stack.pop()] = curVal;
            }
            stack.push(i);
        }
        return ans;
    }

}
