package 每日一题;

/**
 * @author xt
 * @version 1.0
 * @date 2020/10/9 17:35
 */
public class 环形链表 {

    class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
            next = null;
        }
    }

    public boolean hasCycle(ListNode head) {
        if (head == null || head.next == null) return false;
        ListNode head1 = head;
        ListNode head2 = head.next.next;
        while (head2 != null) {
            if (head1 == head2) return true;
            head1 = head1.next;
            if (head2.next == null) return false;
            head2 = head2.next.next;
        }
        return false;
    }

    public boolean hasCycle1(ListNode head) {
        if (head == null || head.next == null) return false;
        ListNode head1 = head;
        ListNode head2 = head.next.next;
        while (head2 != null) {
            if (head1 == head2) return true;
            head1 = head1.next;
            if (head2.next == null) return false;
            head2 = head2.next.next;
        }
        return false;
    }
}
