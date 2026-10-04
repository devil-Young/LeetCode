package LeetCode.q707_设计链表;

/**
 * @author biyangyang79989@zto.com
 * @version 1.0
 * @date 2026-10-04
 */
// 双向链表
public class MyLinkedList2 {

    int size;
    ListNode2 head;
    ListNode2 tail;

    public MyLinkedList2() {
        size = 0;
        head = new ListNode2(0);
        tail = new ListNode2(0);
        head.next = tail;
        tail.prev = head;
    }

    public int get(int index) {
        if (index < 0 || index >= size) {
            return -1;
        }
        ListNode2 current;
        // 距离头尾哪个近
        if (index + 1 < size - index) {
            current = head;
            for (int i = 0; i <= index; i++) {
                current = current.next;
            }
        } else {
            current = tail;
            for (int i = 0; i < size - index; i++) {
                current = current.prev;
            }
        }
        return current.val;
    }

    public void addAtHead(int val) {
        addAtIndex(0, val);
    }

    public void addAtTail(int val) {
        addAtIndex(size, val);
    }

    public void addAtIndex(int index, int val) {
        if (index < 0 || index > size) {
            return;
        }
        //pred = predecessor   // 前驱节点
        //succ = successor     // 后继节点
        ListNode2 pred, succ;
        if (index < size - index) {
            pred = head;
            for (int i = 0; i < index; i++) {
                pred = pred.next;
            }
            succ = pred.next;
        } else {
            succ = tail;
            for (int i = 0; i < size - index; i++) {
                succ = succ.prev;
            }
            pred = succ.prev;
        }
        // 在 pred 和 succ 之间插入新节点
        ListNode2 newNode = new ListNode2(val);
        newNode.next = succ;
        newNode.prev = pred;
        pred.next = newNode;
        succ.prev = newNode;
        size++;
    }

    public void deleteAtIndex(int index) {
        if (index < 0 || index >= size) {
            return;
        }
        ListNode2 pred, succ;
        if (index < size - index) {
            pred = head;
            for (int i = 0; i < index; i++) {
                pred = pred.next;
            }
            succ = pred.next.next;
        } else {
            succ = tail;
            for (int i = 0; i < size - index - 1; i++) {
                succ = succ.prev;
            }
            pred = succ.prev.prev;
        }
        size--;
        pred.next = succ;
        succ.prev = pred;
    }
}
