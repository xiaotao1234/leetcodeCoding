package 每日一题;

/**
 * @author xt
 * @version 1.0
 * @date 2020/10/23 10:42
 */
public class 回文链表 {

    public class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }
    }

    private ListNode frontPointer;

    private boolean recursivelyCheck(ListNode currentNode) {
        if (currentNode != null) {
            if (!recursivelyCheck(currentNode.next)) {
                return false;
            }
            if (currentNode.val != frontPointer.val) {
                return false;
            }
            frontPointer = frontPointer.next;
        }
        return true;
    }

    public boolean isPalindrome1(ListNode head) {
        frontPointer = head;
        return recursivelyCheck(head);
    }

    private ListNode listNode2;

    public boolean isPalindrome2(ListNode head) {//递归版本
        if (head == null) return true;
        listNode2 = head;
        return get(head);
    }

    public boolean get(ListNode listNode) {
        if (listNode != null) {
            if (!get(listNode.next)) {
                return false;
            } else {
                if (listNode.val != listNode2.val) {
                    return false;
                }
                listNode2 = listNode2.next;
            }
        }
        return true;
    }

    public boolean isPalindrome3(ListNode head) {//迭代版本
        ListNode listNode1 = head;
        ListNode listNode2 = head;
        while (listNode2 != null && listNode2.next != null) {
            listNode1 = listNode1.next;
            listNode2 = listNode2.next.next;
        }
        ListNode pre = null;
        ListNode listNode3 = listNode1.next;
        listNode1.next = null;
        while (listNode3 != null) {
            ListNode tmp = listNode3.next;
            listNode3.next = pre;
            pre = listNode3;
            listNode3 = tmp;
        }
        while (pre != null && head != null) {
            if (pre.val != head.val) return false;
            pre = pre.next;
            head = head.next;
        }
        return pre == null && pre == null;
    }



    public boolean isPalindrome(ListNode head) {
        if (head == null) {
            return true;
        }

        // 找到前半部分链表的尾节点并反转后半部分链表
        ListNode firstHalfEnd = endOfFirstHalf(head);
        ListNode secondHalfStart = reverseList(firstHalfEnd.next);

        // 判断是否回文
        ListNode p1 = head;
        ListNode p2 = secondHalfStart;
        boolean result = true;
        while (result && p2 != null) {
            if (p1.val != p2.val) {
                result = false;
            }
            p1 = p1.next;
            p2 = p2.next;
        }

        // 还原链表并返回结果
        firstHalfEnd.next = reverseList(secondHalfStart);
        return result;
    }

    private ListNode reverseList(ListNode head) {
        ListNode prev = null;
        ListNode curr = head;
        while (curr != null) {
            ListNode nextTemp = curr.next;
            curr.next = prev;
            prev = curr;
            curr = nextTemp;
        }
        return prev;
    }

    private ListNode endOfFirstHalf(ListNode head) {
        ListNode fast = head;
        ListNode slow = head;
        while (fast.next != null && fast.next.next != null) {
            fast = fast.next.next;
            slow = slow.next;
        }
        return slow;
    }
}

