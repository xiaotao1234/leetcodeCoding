package 每日一题;

import jdk.nashorn.api.tree.Tree;

/**
 * @author xt
 * @version 1.0
 * @date 2020/9/30 17:37
 */
public class 二叉搜索树中的插入操作 {


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

    public TreeNode insertIntoBST(TreeNode root, int val) {
        return get(root,val);
    }

    public TreeNode get(TreeNode treeNode, int val) {
        if (treeNode == null) return new TreeNode(val);
        if (treeNode.val > val) {
            TreeNode left = get(treeNode.left, val);
            treeNode.left = left;
        } else {
            TreeNode right = get(treeNode.right, val);
            treeNode.right = right;
        }
        return treeNode;
    }
}
