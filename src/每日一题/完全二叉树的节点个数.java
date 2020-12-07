package 每日一题;

/**
 * @author xt
 * @version 1.0
 * @date 2020/11/24 13:00
 */
public class 完全二叉树的节点个数 {
    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

    public int countNodes(TreeNode root) {
        if (root == null) return 0;
        int left = get(root.left);
        int right = get(root.right);
        if (left == right) {
            return (1 << left) + countNodes(root.right);
        } else {
            return countNodes(root.left) + (1 << right);
        }
    }

    public int get(TreeNode treeNode) {
        int leavel = 0;
        while (treeNode != null) {
            treeNode = treeNode.left;
            leavel++;
        }
        return leavel;
    }
}
