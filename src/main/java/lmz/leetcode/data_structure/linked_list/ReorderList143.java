package lmz.leetcode.data_structure.linked_list;

public class ReorderList143 {
    /**
     * leetcode:快慢指针求链表中点
     */
    public void reorderList(ListNode head) {
        if (head == null) {
            return;
        }
        ListNode mid = middleNode(head);
        ListNode l1 = head;
        ListNode l2 = mid.next;
        mid.next = null;
        //逆置后半段
        l2 = reverseList(l2);
        mergeList(l1,l2);
    }
    /**
     * 快慢双指针
     */
    public ListNode middleNode(ListNode head) {
        ListNode slow = head, fast = head;
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        return slow;
    }
    public ListNode reverseList(ListNode head) {
        ListNode preNode = null;
        while (head != null){
            ListNode temp = head.next;
            head.next = preNode;
            preNode = head;
            head = temp;
        }
        return preNode; //preNode为尾结点
    }
    public void mergeList(ListNode l1, ListNode l2) {
        ListNode l1_tmp;
        ListNode l2_tmp;
        while (l1 != null && l2 != null) {
            l1_tmp = l1.next;
            l2_tmp = l2.next;

            l1.next = l2;
            l1 = l1_tmp;

            l2.next = l1;
            l2 = l2_tmp;
        }
    }

    public void reorderList1(ListNode head) {
        // 链表的长度范围为 [1, 5 * 104]
        ListNode cur = head;
        int len = 0;
        while (cur != null) {
            cur = cur.next;
            len++;
        }
        if(len == 1){ //不需要reorder
            return;
        }
        int mid = len / 2 + 1; //因为逆置只需要后半段
        ListNode preMid = head;
        ListNode midNode = head.next;
        for (int i = 2; i < mid; i++) {
            preMid = midNode;
            midNode = midNode.next;
        }
        preMid.next = null; // 将前半段置为一个链表
        //逆置后半段
        ListNode pre = midNode;

        cur = midNode.next;
        midNode.next = null;
        while (cur != null) {
            ListNode next = cur.next;
            cur.next = pre;
            pre = cur;
            cur = next;
        }
        ListNode right = pre;
        ListNode left = head;
        cur = new ListNode();
        while(left != null && right != null){
            cur.next = left;
            left = left.next;
            cur = cur.next;
            cur.next = right;
            right = right.next;
            cur = cur.next;
        }
        if(left != null){
            cur.next = left.next;
        }
    }
}
