package 每日一题;

/**
 * @author xt
 * @version 1.0
 * @date 2020/10/29 13:05
 */
public class 二叉树中的最大路径和 {
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
}
