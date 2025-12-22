package LeetCode.q61_旋转链表;

/**
 * @Author: Young
 * @Date: 2025/12/23 01:19
 */
public class Solution {
    public ListNode rotateRight(ListNode head, int k) {
        if (head == null || head.next == null|| k == 0) {
            return head;
        }
        //计算链表长度
        int length = 1;
        ListNode iter = head;
        while (iter.next != null) {
            length++;
            iter = iter.next;
        }

        int rotateSteps = length - k % length;

        if (rotateSteps == length) {
            return  head;
        }

        ListNode p = head;
        while (rotateSteps > 1) {
            p = p.next;
            rotateSteps--;
        }

        ListNode cur = p.next;
        iter.next = head;
        p.next = null;

        return cur;

    }
}
