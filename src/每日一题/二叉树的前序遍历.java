package 每日一题;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * @author xt
 * @version 1.0
 * @date 2020/10/27 8:39
 */
public class 二叉树的前序遍历 {
    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode() {
        }

        TreeNode(int val) {
            this.val = val;
        }

        TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }

    List<Integer> list = new ArrayList<>();

    public List<Integer> preorderTraversal(TreeNode root) {//递归
        if (root == null) return list;
        list.add(root.val);
        preorderTraversal(root.left);
        preorderTraversal(root.right);
        return list;
    }

    public List<Integer> preorderTraversal1(TreeNode root) {//迭代
        List<Integer> list = new ArrayList<>();
        if (root == null) return list;
        Stack<TreeNode> stack = new Stack<>();
        TreeNode treeNode = root;
        while (!stack.isEmpty() || treeNode != null) {
            while (treeNode != null) {
                list.add(treeNode.val);
                stack.push(treeNode);
                treeNode = treeNode.left;
            }
            if (!stack.isEmpty()) {
                treeNode = stack.pop();
                treeNode = treeNode.right;
            }
        }
        return list;
    }
}
