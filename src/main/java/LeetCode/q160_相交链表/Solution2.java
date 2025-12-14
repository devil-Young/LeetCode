package LeetCode.q160_相交链表;

//双指针
// 空间复杂度 o(1)
public class Solution2 {
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        if (headA == null || headB == null){
            return null;
        }
        ListNode pA = headA;
        ListNode PB = headB;
        while (pA != PB){
            pA = pA == null ? headB : pA.next;
            PB = PB == null ? headA : PB.next;
        }

        return null;
    }
}
