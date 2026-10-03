package LeetCode.q203_移除链表元素;

/**
 * @author biyangyang79989@zto.com
 * @version 1.0
 * @date 2026-10-04
 */
// 递归
public class Solution3 {
    //删除以 head 为头节点的链表中所有 val 后，剩余链表的头节点。
    public ListNode removeElements(ListNode head, int val) {
        if (head == null) return head;
        head.next = removeElements(head.next, val);
        return head.val == val ? head.next : head;
    }
}
