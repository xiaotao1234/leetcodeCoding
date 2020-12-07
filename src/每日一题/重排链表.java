package 每日一题;

/**
 * @author xt
 * @version 1.0
 * @date 2020/10/20 8:26
 */
public class 重排链表 {
    public void reorderList(ListNode head) {
        if (head == null) return;

        ListNode listNode1 = head;
        ListNode listNode2 = head;
        while (listNode2 != null && listNode2.next != null) {
            listNode2 = listNode2.next.next;
            listNode1 = listNode1.next;
        }

        ListNode pre = null;
        ListNode next;
        next = listNode1.next;
        listNode1.next = null;
        listNode1 = next;
        while (listNode1 != null) {
            next = listNode1.next;
            listNode1.next = pre;
            pre = listNode1;
            listNode1 = next;
        }

        ListNode listNode = head;
        while (listNode != null && pre != null) {
            ListNode tmp = listNode.next;
            ListNode tmp1 = pre.next;
            listNode.next = pre;
            pre.next = tmp;
            listNode = tmp;
            pre = tmp1;
        }
    }

//    public ListNode get(ListNode listNode, ListNode listNode1) {
//        if (listNode1 == null || listNode1.next == null) {
//            return listNode1;
//        }
//        ListNode listNode2 = get(listNode, listNode1.next);
//        listNode.next = listNode2;
//        listNode2.next = listNode.next;
//    }


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
}
