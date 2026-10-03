package LeetCode.q203_移除链表元素;

/**
 * @author biyangyang79989@zto.com
 * @version 1.0
 * @date 2026-10-04
 */
public class solution2 {
    public ListNode removeElements(ListNode head, int val) {
        ListNode dummyHead = new ListNode(0);
        dummyHead.next = head;
        ListNode current = dummyHead;
        while (current.next != null) {
            if (current.next.val == val) {
                current.next = current.next.next;
            }else  {
                current = current.next;
            }
        }
        return  dummyHead.next;
    }
}
