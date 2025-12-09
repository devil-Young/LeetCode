package q147_对链表进行插入排序;

/**
 * @Author: Young
 * @Date: 2025/6/13 15:46
 */
public class Solution {
    public ListNode insertionSortList(ListNode head) {
        if (head == null) {
            return  head;
        }
        ListNode dummyHead = new ListNode(0); // 哨兵节点
        dummyHead.next = head; // 哨兵节点指向原链表头
        ListNode lastSorted = head; // 已排序部分的最后一个节点
        ListNode cur = head.next;// 当前待插入的节点

        while (cur != null) {
            if (lastSorted.val <= cur.val) {
                lastSorted = lastSorted.next;
            } else {
                // 找到插入位置
                ListNode prev = dummyHead;
                while (prev.next.val <= cur.val) {
                    prev = prev.next;
                }
                lastSorted.next = cur.next;
                cur.next = prev.next;
                prev.next = cur;

            }
            cur = lastSorted.next;
        }
        return dummyHead.next;
    }
}
