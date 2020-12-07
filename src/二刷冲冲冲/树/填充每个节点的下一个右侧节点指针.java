package 二刷冲冲冲.树;

/**
 * @author xt
 * @version 1.0
 * @date 2020/9/28 22:59
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
        if (root == null) return null;
        get(root.left, root.right);
        return root;
    }

    public void get(Node leftNode, Node rightNode) {
        if (leftNode == null) return;
        leftNode.next = rightNode;
        get(leftNode.left, leftNode.right);
        get(leftNode.right, rightNode.left);
        get(rightNode.left, rightNode.right);
    }


    public Node connect1(Node root) {//下一层依靠上一层
        get(root);
        return root;
    }

    public void get(Node root) {
        if (root == null) {
            return;
        }
        if (root.left != null) {
            root.left.next = root.right;
            root.right.next = root.next == null ? null : root.next.left;
        }
        get(root.left);
        get(root.right);
    }
}
