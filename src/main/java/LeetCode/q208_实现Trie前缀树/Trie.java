package LeetCode.q208_实现Trie前缀树;

/**
 * @Author: Young
 * @Date: 2025/12/16 17:55
 */
public class Trie {

    private final Node root = new Node();

    public void insert(String word) {
        Node cur = root;
        for (int i = 0; i < word.length(); i++) {
            char c = word.charAt(i);
            int index = c - 'a';
            if (cur.son[index] == null) {
                cur.son[index] = new Node();
            }
            cur = cur.son[index];
        }
        cur.end = true;
    }

    public boolean search(String word) {
        Node node = searchPrefix(word);
        return node != null && node.end;
    }

    public boolean startsWith(String prefix) {
        Node node = searchPrefix(prefix);
        return node != null;
    }

    private Node searchPrefix(String prefix) {
        Node cur = root;
        for (int i = 0; i < prefix.length(); i++) {
            char ch = prefix.charAt(i);
            int index = ch - 'a';
            if (cur.son[index] == null) {
                return null;
            }
            cur = cur.son[index];
        }
        return cur;
    }

}


class Node {
    Node[] son = new Node[26];
    boolean end = false;
}
