package 二刷冲冲冲.链表.节点定位;

/**
 * @author xt
 * @version 1.0
 * @date 2020/10/20 23:19
 */
public class 链表倒数第N个节点 {
    public class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }
    }

    public ListNode getKthFromEnd(ListNode head, int k) {
        ListNode listNode1 = head;
        while (k != 0) {
            listNode1 = listNode1.next;
            k--;
        }
        while (listNode1 != null) {
            listNode1 = listNode1.next;
            head = head.next;
        }
        return head;
    }

    ListNode listNode;

    public ListNode getKthFromEnd1(ListNode head, int k) {
        get(head, k);
        return listNode;
    }

    public int get(ListNode listNode1, int k) {
        if (listNode1 == null) return k;
        int m = get(listNode1.next, k);
        if (m == 0) listNode = listNode1;
        return m - 1;
    }
}
