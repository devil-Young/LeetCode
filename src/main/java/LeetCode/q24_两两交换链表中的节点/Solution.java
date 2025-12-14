package LeetCode.q24_两两交换链表中的节点;

/**
 * @Author: Young
 * @Date: 2023/9/24 20:44
 *
 * 递归
 * head 表示原始链表的头节点，新的链表的第二个节点，
 * 用 newHead 表示新的链表的头节点，原始链表的第二个节点，则原始链表中的其余节点的头节点是 newHead.next
 *
 */
public class Solution {
    public ListNode swapPairs(ListNode head) {
        // 链表偶数 head == null 奇数 head.next == null
        if (head == null || head.next == null) {
            return head;
        }
        // 1 > 2 > 3 > 4
        ListNode newHead = head.next;
        head.next = swapPairs(newHead.next);
        // 4 > 3
        newHead.next = head;
        return newHead;
    }
}
