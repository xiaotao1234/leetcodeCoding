package 二刷冲冲冲.链表;

/**
 * @author xt
 * @version 1.0
 * @date 2020/10/13 20:57
 */
public class 两两交换链表中的节点 {
    public class ListNode {
        int val;
        ListNode next;

        ListNode() {
        }

        ListNode(int val) {
            this.val = val;
        }

        ListNode(int val, ListNode next) {
            this.val = val;
            this.next = next;
        }
    }


    public ListNode swapPairs(ListNode listNode) {//递归
        if (listNode == null || listNode.next == null) return listNode;
        ListNode listNode1 = listNode.next;
        listNode.next = listNode1.next;
        listNode1.next = listNode;
        return listNode1;
    }

    public ListNode swapPairs1(ListNode listNode) {//非递归
        ListNode pre = new ListNode(0);
        pre.next = listNode;
        ListNode tmp = pre;
        while (tmp != null && tmp.next != null && tmp.next.next != null) {
            ListNode start = tmp.next;
            ListNode end = start.next;
            start.next = end.next;
            end.next = start;
            tmp.next = end;
            tmp = start;
        }
        return pre.next;
    }
}
