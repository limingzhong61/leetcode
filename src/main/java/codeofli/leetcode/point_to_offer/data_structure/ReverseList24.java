package codeofli.leetcode.point_to_offer.data_structure;


public class ReverseList24 {

    /**
     * my: 递归逆置
     */
    public ListNode reverseList(ListNode head) {
        if(head == null || head.next == null){
            return head;
        }
        ListNode next = reverseList(head.next);
        //防止产生环
        head.next.next = head;
        head.next = null;
        return next;
    }
    /**
     * my: 头插法逆置
     */
    public ListNode reverseList1(ListNode head) {
        ListNode dummyHead = new ListNode(-1);
        dummyHead.next = null;
        //ListNode cur = head;
        while(head != null){
            ListNode temp = head.next;
            head.next = dummyHead.next;
            dummyHead.next = head;
            head = temp;
        }
        return dummyHead.next;
    }

    /**
     * 直接逆置
     * leetcode: 直接指向前一个pre结点，最初始的pre结点为null
     */
    public ListNode reverseList2(ListNode head) {
        ListNode prev = null;
        ListNode cur = head;
        while(cur != null){
            ListNode next = cur.next;
            cur.next = prev;
            prev = cur;
            cur = next;
        }
        return prev;
    }
}
