package 每日一题;

/**
 * @author xt
 * @version 1.0
 * @date 2020/10/15 11:10
 */
public class 填充每个节点的下一个右侧节点指针 {
    class Node {
        public int val;
        public Node left;
        public Node right;
        public Node next;

        public Node() {
        }

        public Node(int _val) {
            val = _val;
        }

        public Node(int _val, Node _left, Node _right, Node _next) {
            val = _val;
            left = _left;
            right = _right;
            next = _next;
        }
    }

    ;

    public Node connect(Node root) {
        if (root == null) return root;
        get(root.left, root.right);
        return root;
    }

    public void get(Node node1, Node node2) {//递归
        if (node1 == null) return;
        node1.next = node2;
        get(node1.left, node1.right);
        get(node1.right, node2 == null ? null : node2.left);
    }

    public Node connect1(Node root) {
        dfs(root, null);
        return root;
    }

    private void dfs(Node curr, Node next) {
        if (curr == null) return;
        curr.next = next;
        dfs(curr.left, curr.right);
        dfs(curr.right, curr.next == null ? null : curr.next.left);
    }
}
