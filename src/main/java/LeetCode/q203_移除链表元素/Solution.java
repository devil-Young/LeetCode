package LeetCode.q203_移除链表元素;

/**
 * @author biyangyang79989@zto.com
 * @version 1.0
 * @date 2026-10-03
 */
// 迭代 不用虚拟头结点
public class Solution {
    public ListNode removeElements(ListNode head, int val) {
        while (head != null && head.val == val) {
            head = head.next;
        }
        ListNode current = head;
        while (current != null && current.next != null) {
            if (current.next.val == val) {
                current.next = current.next.next;
            }else  {
                current = current.next;
            }
        }
        return  head;
    }
}
