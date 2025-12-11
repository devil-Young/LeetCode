/**
 * @Author: Young
 * @Date: 2025/12/1 11:05
 */
public class Solution {
    public ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode prev = new ListNode(0, head);
        ListNode prevHead = prev;
        int length = 0;
        ListNode ptr = head;
        while (ptr != null) {
            length++;
            ptr = ptr.next;
        }

        //边界 length - n -1 或者<
        for (int i = 1; i <= length - n; i++) {
            prev = prev.next;
        }
        ListNode deled = prev.next;
        prev.next = prev.next.next;
        deled.next = null;


        return prevHead.next;
    }

}

class ListNode {
    int val;
    ListNode next;

    ListNode() {
    }

    ListNode(int val) {
        this.val = val;
    }

    ListNode(int val, ListNode next) {
        this.val = val;
        this.next = next;
    }
}