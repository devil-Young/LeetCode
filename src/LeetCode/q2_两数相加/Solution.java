package q2_两数相加;

/**
 * @author ：Young
 * @date ：Created in 2022/2/10 17:19
 */

public class Solution {

    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode head = null;
        ListNode tail = null;
        // 进位
        int carry = 0;

        while (l1!=null || l2!=null){
            int n1 = l1 != null ? l1.val : 0;
            int n2 = l2 != null ? l2.val : 0;
            int sum = n1 + n2 + carry;
            if (head == null){
                head = tail = new ListNode(sum % 10);
            }else {
                tail.next = new ListNode(sum % 10);
                // 生成链表尾指针后移
                tail = tail.next;
            }
            carry = sum / 10;
            // l1 l2 指针后移
            if (l1 != null){
                l1 = l1.next;
            }
            if (l2 != null){
                l2 = l2.next;
            }

        }
        // 最后的节点相加 有可能产生进位
        if (carry > 0){
            tail.next = new ListNode(carry);
        }
        return head;
    }

    /**
     *  递归
     */
    public ListNode addTwoNumbers2(ListNode l1, ListNode l2) {
        return recursive(l1, l2, 0);
    }

    private ListNode recursive(ListNode l1, ListNode l2, int carry) {
        if (l1 == null && l2 == null && carry==0){
            return null;
        }

        int sum = carry;

        if (l1 != null){
            sum += l1.val;
            l1 = l1.next;
        }
        if (l2 != null){
            sum += l2.val;
            l2 = l2.next;
        }

        ListNode node = new ListNode(sum % 10);
        node.next = recursive(l1, l2, sum / 10);
        return node;
    }



}
