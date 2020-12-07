/**
 * @author xt
 * @version 1.0
 * @date 2020/10/13 21:06
 */
public class K个一组翻转链表 {

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


    public ListNode reverseKGroup(ListNode head, int s) {
        ListNode listNode = head;
        int index = s;
        while (listNode != null && s > 0) {
            listNode = listNode.next;
            s--;
        }
        if (s > 0) return head;
        ListNode pre = head;
        listNode = reverseKGroup(listNode.next, index);
        while (index != s) {
            index++;
            ListNode listNode1 = pre.next;
            pre.next = listNode;
            listNode = pre;
            pre = listNode1;
        }
        return listNode.next;
    }

}


