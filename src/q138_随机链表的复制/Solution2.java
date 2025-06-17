package q138_随机链表的复制;

/**
 * @Author: Young
 * @Date: 2025/6/18 00:47
 * <p>
 * 方法二：迭代 + 节点拆分
 */
public class Solution2 {
    public Node copyRandomList(Node head) {
        if (head == null) {
            return null;
        }

        for (Node node = head; node != null; node = node.next.next) {
            Node nodeNew = new Node(node.val);
            nodeNew.next = node.next;
            node.next = nodeNew;
        }

        for (Node node = head; node != null; node = node.next.next) {
            Node nodeNew = node.next;
            nodeNew.random = (node.random != null) ? node.random.next : null;
        }

        Node headNew = head.next;
        for (Node node = head; node != null; node = node.next) {
            Node nodeNew = node.next;
            node.next = node.next.next;
            nodeNew.next = (nodeNew.next != null) ? nodeNew.next.next : null;
        }

        return headNew;
    }
}
