package 二刷冲冲冲.树;

import java.util.ArrayList;
import java.util.List;

/**
 * @author xt
 * @version 1.0
 * @date 2020/11/28 9:36
 */
public class 二叉搜索树与双向链表 {
    class Node {
        public int val;
        public Node left;
        public Node right;

        public Node() {
        }

        public Node(int _val) {
            val = _val;
        }

        public Node(int _val, Node _left, Node _right) {
            val = _val;
            left = _left;
            right = _right;
        }
    }

    public Node treeToDoublyList(Node root) {
        if (root == null) return null;
        List<Node> list = new ArrayList<>();
        get1(root, list);
        Node pre = list.get(0);
        Node current = pre;
        for (int i = 1; i < list.size(); i++) {
            pre.right = list.get(i);
            list.get(i).left = pre;
            pre = list.get(i);
        }
        list.get(list.size() - 1).right = current;
        current.left = list.get(list.size() - 1);
        return current;
    }

    public void get1(Node node, List<Node> list) {
        if (node == null) return;
        get1(node.left, list);
        list.add(node);
        get1(node.right, list);
    }

    Node pre, head;

    public Node treeToDoublyList1(Node root) {
        if (root == null) return root;
        dfs(root);
        pre.right = head;
        head.left = pre;
        return head;
    }

    void dfs(Node cur) {
        if (cur == null) return;
        dfs(cur.left);
        if (pre != null) pre.right = cur;
        else head = cur;
        cur.left = pre;
        pre = cur;
        dfs(cur.right);
    }
}
