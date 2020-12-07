package 每日一题;

/**
 * @author xt
 * @version 1.0
 * @date 2020/10/18 15:22
 */
public class 删除链表的倒数第N个节点 {
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

    int s = 0;

    public ListNode removeNthFromEnd(ListNode head, int n) {
        if (head == null) {
            return head;
        }
        head.next = removeNthFromEnd(head.next, n);
        s++;
        if (s == n) return head.next;
        return head;
    }

    public ListNode removeNthFromEnd1(ListNode head, int n) {//双指针
        ListNode headpre = new ListNode(0);
        headpre.next = head;
        ListNode listNode1 = headpre;
        ListNode listNode2 = headpre;
        int i = 0;
        while (i <= n) {
            listNode2 = listNode2.next;
            i++;
        }
        while (listNode2 != null) {
            listNode1 = listNode1.next;
            listNode2 = listNode2.next;
        }
        listNode1.next = listNode1.next.next;
        return headpre.next;
    }
}
