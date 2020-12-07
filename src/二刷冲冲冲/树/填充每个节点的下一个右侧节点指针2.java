package 二刷冲冲冲.树;

import org.w3c.dom.Node;

/**
 * @author xt
 * @version 1.0
 * @date 2020/9/28 22:07
 */
public class 填充每个节点的下一个右侧节点指针2 {

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

    public Node connect(Node root) {
        get(root.left, root.right);
        return root;
    }

    public void get(Node node1, Node node2) {
        if (node1 != null) {
            node1.next = node2;
            get(node1.left, node1.right);
            if (node2 != null) {
                get(node1.right, node2.left);
                get(node2.left, node2.right);
            }
        }
    }

//    public void get(Node node) {
//        if (node == null) return;
//        if (node.left != null){
//            if(no)
//            node.left.next
//        }
//    }
}
