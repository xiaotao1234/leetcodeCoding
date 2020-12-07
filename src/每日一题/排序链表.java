package 每日一题;

/**
 * @author xt
 * @version 1.0
 * @date 2020/11/21 9:23
 */
public class 排序链表 {
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

    public ListNode sortList1(ListNode head) { //插入排序法
        ListNode dummy = new ListNode(0);//指向头节点的节点
        ListNode pre = dummy;//pre为上次搜索的位置

        for (ListNode node = head; node != null; ) {
            ListNode cur = node; //当前待排序节点
            node = node.next;  //先记录起下一个节点，作为下一个待排序节点

            // 与前一个插入点比较决定从哪里开始搜索
            if (cur.val < pre.val) pre = dummy;//若本节点的值比上次搜索节点的值小，
            // 那么需要把搜索节点的位置重新放置到开头位置

            // 从搜索节点起始位置开始逐渐向后搜索直到找到待排序节点的插入位置
            while (pre.next != null && cur.val > pre.next.val)
                pre = pre.next;

            //将待排序节点插入该位置
            cur.next = pre.next;
            pre.next = cur;

            //继续向后直到到节点尾部
        }

        return dummy.next;
    }

    public ListNode sortList(ListNode head) {  //插入排序
        ListNode dump = new ListNode(0);
        ListNode pre = dump;
        for (ListNode node = head; node != null; ) {
            ListNode cur = node;//记录当前待排序节点
            node = node.next;//延申到下一个节点
            pre = dump;
            while (pre.next != null && cur.val > pre.next.val) {
                // 有序序列的遍历节点的下一个节点不为空，且待排序节点的值比下一个节点值大，
                // 这意味着待排序节点不能插入到遍历节点到遍历节点的下一个节点之间
                pre = pre.next;
            }
            cur.next = pre.next;
            pre.next = cur;
        }
        return dump.next;
    }

    public ListNode sortList2(ListNode head) {
        ListNode dump = new ListNode(0);
        ListNode pre;
        for (ListNode node = head; node != null; ) {
            ListNode cur = node;
            node = node.next;
            pre = dump;
            while (pre.next != null && pre.next.val < cur.val) {
                pre = pre.next;
            }
            cur.next = pre.next;
            pre.next = cur;
        }
        return dump.next;
    }
}
