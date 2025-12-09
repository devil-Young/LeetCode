package q138_随机链表的复制;

import java.util.HashMap;
import java.util.Map;

/**
 * @Author: Young
 * @Date: 2025/2/16 11:11
 * 方法一：回溯 + 哈希表
 */
public class Solution {
    Map<Node, Node> cachedNode = new HashMap<Node, Node>();

    public Node copyRandomList(Node head) {
        if (head == null) {
            return null;
        }
        if (!cachedNode.containsKey(head)) {
            Node headNew = new Node(head.val);
            cachedNode.put(head, headNew);
            headNew.next = copyRandomList(head.next);
            headNew.random = copyRandomList(head.random);
        }
        return cachedNode.get(head);
    }
}
