package 二刷冲冲冲.树;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Stack;

/**
 * @author xt
 * @version 1.0
 * @date 2020/10/20 23:28
 */
public class 二叉树的Z字形分层遍历 {
    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        List<List<Integer>> lists = new ArrayList<>();
        get(Arrays.asList(root), true, lists);
        return lists;
    }

    public void get(List<TreeNode> list, boolean s, List<List<Integer>> lists) {
        if (list.size() == 0) return;
        List<TreeNode> list1 = new ArrayList<>();
        List<Integer> list2 = new ArrayList<>();
        for (TreeNode treeNode : list) {
            if (treeNode.left != null) list1.add(treeNode.left);
            if (treeNode.right != null) list1.add(treeNode.right);
            if (s) list2.add(treeNode.val);
            else list2.add(treeNode.val, 0);
        }
        lists.add(list2);
        get(list1, !s, lists);
    }

    public List<List<Integer>> zigzagLevelOrder1(TreeNode root) {
        List<List<Integer>> lists = new ArrayList<>();
        if (root == null) return lists;
        get1(Arrays.asList(root), true, lists);
        return lists;
    }

    public void get1(List<TreeNode> list, boolean s, List<List<Integer>> lists) {
        if (list.size() == 0) return;
        List<TreeNode> list1 = new ArrayList<>();
        List<Integer> list2 = new ArrayList<>();
        for (TreeNode treeNode : list) {
            if (treeNode.left != null) list1.add(treeNode.left);
            if (treeNode.right != null) list1.add(treeNode.right);
            if (s) list2.add(treeNode.val);
            else list2.add(0, treeNode.val);
        }
        get1(list1, !s, lists);
    }
}

