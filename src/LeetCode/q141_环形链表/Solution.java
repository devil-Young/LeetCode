package q141_环形链表;

import java.util.HashSet;

public class Solution {
    public boolean hasCycle(ListNode head) {
        HashSet<ListNode> seen = new HashSet<>();
        while (head != null) {
            if (!seen.add(head)) {
                return true;
            }
            head = head.next;
        }

        return false;
    }
}
