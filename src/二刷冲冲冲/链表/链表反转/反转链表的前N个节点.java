package 二刷冲冲冲.链表.链表反转;

/**
 * @author xt
 * @version 1.0
 * @date 2020/11/3 23:43
 */
public class 反转链表的前N个节点 {

    public class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }
    }

    ListNode record;

    public ListNode reverseN(ListNode listNode, int n) {
        if (listNode == null) return null;
        if (n == 1) {
            record = listNode.next;
            return listNode;
        }
        ListNode l = reverseN(listNode.next, n - 1);
        listNode.next.next = listNode;
        listNode.next = record;
        return l;
    }
}
