package 每日一题;

/**
 * @author xt
 * @version 1.0
 * @date 2020/11/13 8:28
 */
public class 奇偶链表 {
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

    public ListNode oddEvenList(ListNode head) {
        ListNode listNodeJ = new ListNode(1);
        ListNode listNodeO = new ListNode(1);
        ListNode J = listNodeJ;
        ListNode O = listNodeO;
        ListNode l;
        boolean isJ = true;
        while (head != null) {
            if (isJ) {
                J.next = head;
            } else {
                O.next = head;
            }
            l = head.next;
            head.next = null;
            head = l;
            isJ = !isJ;
        }
        J.next = listNodeO.next;
        return listNodeJ.next;
    }
}
