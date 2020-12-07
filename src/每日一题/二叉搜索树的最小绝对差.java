package 每日一题;

/**
 * @author xt
 * @version 1.0
 * @date 2020/10/12 17:05
 */
public class 二叉搜索树的最小绝对差 {   //中序遍历之于二叉搜索数就是一个递增的遍历顺序，因为二叉搜索数就是:左边>中间>右边,而这也正是中序遍历的顺序
    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

    public int getMinimumDifference(TreeNode root) {
        get(root.left);
        get(root.right);
        return min;
    }

    int min = Integer.MAX_VALUE;
    TreeNode pre = null;

    public void get(TreeNode treeNode) {
        if (treeNode == null) return;
        get(treeNode.left);
        min = Math.min(min, Math.abs(treeNode.val - pre.val));
        get(treeNode.right);
    }

    private int result = Integer.MAX_VALUE;
    private TreeNode preNode = null;

    public int getMinimumDifference1(TreeNode root) {
        //二叉查找树中，中间节点的值一定是其左右节点值的中间数，因此最小差别一定是在中间节点与左右节点之间
        //中序遍历二叉查找树，每次比较当前节点与前一节点差值的绝对值与目前result中保存的最小值的大小，将较小的保存在result中
        getMin(root);
        return result;
    }


    public void getMin(TreeNode treeNode) {
        if (treeNode == null) return;
        getMin(treeNode.left);
        if (preNode != null) {
            result = Math.min(Math.abs(preNode.val - treeNode.val), min);
        }
        preNode = treeNode;
        getMin(treeNode.right);
    }

}









