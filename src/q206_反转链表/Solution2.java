package q206_反转链表;

// 递归
public class Solution2 {
    public ListNode reverseList(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }

        ListNode  newHead = reverseList(head.next);
        head.next.next = head;
        head.next = null;
        return newHead;
    }
}
