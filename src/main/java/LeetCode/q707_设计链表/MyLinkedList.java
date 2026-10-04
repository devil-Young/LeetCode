package LeetCode.q707_设计链表;

/**
 * @author biyangyang79989@zto.com
 * @version 1.0
 * @date 2026-10-04
 */
public class MyLinkedList {
    int size;
    ListNode dummyHead;

    public MyLinkedList() {
        size = 0;
        dummyHead = new ListNode(0);
    }

    public int get(int index) {
        if (index < 0  || index >= size){
            return -1;
        }
        ListNode current = dummyHead.next;
        for (int i = 0; i < index; i++) {
            current = current.next;
        }
        return  current.val;
    }

    public void addAtHead(int val) {
        addAtIndex(0, val);
    }

    public void addAtTail(int val) {
        addAtIndex(size, val);
    }

    public void addAtIndex(int index, int val) {
        // 0 -- size
        if (index < 0 || index > size) {
            return;
        }
        size++;
        ListNode current = dummyHead;
        for (int i = 0; i < index; i++) {
            current = current.next;
        }
        ListNode newNode = new ListNode(val);
        newNode.next = current.next;
        current.next = newNode;
    }

    public void deleteAtIndex(int index) {
        if (index < 0 || index >= size){
            return;
        }
        ListNode current = dummyHead;
        for (int i = 0; i < index; i++) {
            current = current.next;
        }
        current.next = current.next.next;
        size--;
    }
}
