package LeetCode.q23_合并K个升序链表;

import java.util.PriorityQueue;

/**
 * @Author: Young
 * @Date: 2023/9/24 19:59
 *
 * 使用优先队列合并
 * 需要维护当前每个链表没有被合并的元素的最前面一个，kkk 个链表就最多有 kkk 个满足这样条件的元素，
 * 每次在这些元素里面选取 val 属性最小的元素合并到答案中。在选取最小元素的时候，我们可以用优先队列来优化这个过程。
 */
public class Solution3 {
    class Status implements Comparable<Status> {
        int val;
        ListNode ptr;

        public Status(int val, ListNode ptr) {
            this.val = val;
            this.ptr = ptr;
        }

        @Override
        public int compareTo(Status status2) {
            return this.val - status2.val;
        }
    }

    PriorityQueue<Status> queue= new PriorityQueue<Status>();

    public ListNode mergeKLists(ListNode[] lists) {
        for (ListNode node: lists) {
            if (node != null) {
                queue.offer(new Status(node.val, node));
            }
        }
        ListNode head  = new ListNode(0);
        ListNode tail = head;
        while (!queue.isEmpty()) {
            Status f = queue.poll();
            tail.next = f.ptr;
            tail = tail.next;
            if (f.ptr.next != null) {
                queue.offer(new Status(f.ptr.next.val, f.ptr.next));
            }
        }
        return head.next;
    }
}
