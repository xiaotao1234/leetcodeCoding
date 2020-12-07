package 每日一题;

/**
 * @author xt
 * @version 1.0
 * @date 2020/10/29 13:00
 */
public class 求根到叶子节点数字之和 {
    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

    public int sumNumbers(TreeNode root) {
        if (root == null) return 0;
        get(root, 0);
        return all;
    }

    int all = 0;

    public void get(TreeNode treeNode, int now) {
        if (treeNode == null || (treeNode.left == null && treeNode.right == null)) {
            if (treeNode != null) all = all + now * 10 + treeNode.val;
            return;
        }
        now = now * 10 + treeNode.val;
        get(treeNode.left, now);
        get(treeNode.right, now);
    }
}
