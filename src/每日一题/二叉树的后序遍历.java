package 每日一题;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * @author xt
 * @version 1.0
 * @date 2020/9/29 18:14
 */
public class 二叉树的后序遍历 {

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

    public List<Integer> postorderTraversal(TreeNode root) {
        get(root);
        return list;
    }

    List<Integer> list = new ArrayList<>();

    public void get(TreeNode treeNode) {
        if (treeNode == null) return;
        get(treeNode.left);
        get(treeNode.right);
        list.add(treeNode.val);
    }

    public List<Integer> postorderTraversal1(TreeNode root) {
        List<Integer> list = new ArrayList<>();
        if (root == null) return list;
        TreeNode treeNode = null;
        Stack<TreeNode> stack = new Stack<>();
        while (!stack.isEmpty() || root != null) {//当当前节点不为空或者栈不为空时
            if (root != null) {//若当前节点不为空，代表当前节点不为空而且及其分支还未遍历
                stack.push(root);//当前节点入栈
                root = root.left;//遍历当前节点左节点
            } else {//若当前节点为空，代表到了一个分支的末尾
                root = stack.pop();//将当前节点指向栈顶，及回退到上一个还未记录节点值得分支上
                if (root.right == null || treeNode.right != treeNode) {//若当前节点右分支为空或者右分支为刚刚已经遍历过得节点
                    list.add(root.val);//代表当前节点得左右遍历完毕，将当前节点值进行记录（即后续遍历）
                    treeNode = root;//将指示上一个右分支的节点指针指向当前节点，避免再次遍历进去
                } else {//若右节点还未遍历
                    root = root.right;//遍历右节点
                }
            }
        }
        return list;
    }
}




















