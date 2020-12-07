package 每日一题;

/**
 * @author xt
 * @version 1.0
 * @date 2020/11/20 13:02
 */
public class 对链表进行插入排序 {
    //和插入排序类似，我们每次的操作就是将一个节点插入到前面有序节点的合适位置，
    //开始时有序节点序列没用元素，然后逐渐插入节点时，我们的节点数目逐渐增加，对一个节点的插入操作流程为
    //从有序序列的起始位置（这里优化了一下先在上次插入位置判断在其前还是后，前的话从开头遍历查找，
    // 否则直接从当前位置开始查找），开始往后查找，直到找到一个合适插入的位置进行插入
    public class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }
    }

    public ListNode insertionSortList1(ListNode head) {
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


    public ListNode insertionSortList2(ListNode head) {
        ListNode target = new ListNode(0);
        ListNode pre = target;

        for (ListNode next = head; next != null; ) {
            ListNode cur = next;
            next = next.next;

            if (pre.val > cur.val) pre = target;

            while (pre.next != null && pre.next.val < cur.val) {
                pre = pre.next;
            }

            cur.next = pre.next;
            pre.next = cur;
        }
        return target.next;
    }

    public ListNode insertionSortList3(ListNode head) {
        ListNode newHead = new ListNode(0);
        ListNode pre = newHead;

        for (ListNode next = head; next != null; ) {
            ListNode cur = next;
            next = next.next;

            if (cur.val < pre.val) pre = newHead;

            while (pre.next != null && cur.val < pre.next.val) {
                pre = pre.next;
            }

            cur.next = pre.next;
            pre.next = cur;
        }
        return newHead.next;
    }
}
