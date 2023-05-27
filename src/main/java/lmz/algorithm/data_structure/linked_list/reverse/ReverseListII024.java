package lmz.algorithm.data_structure.linked_list.reverse;

import lmz.algorithm.data_structure.linked_list.ListNode;

/**
 * @author: limingzhong
 * @create: 2023-01-24 15:25
 */
public class ReverseListII024 {
    /**
     * 2.递归逆置
     */
    public ListNode reverseList(ListNode head) {
       if(head == null || head.next == null){
           return  head;
       }
        ListNode newHead = reverseList(head.next);
        head.next.next = head;
        head.next = null;
       return newHead;
    }
    /**
     * 1.迭代逆置
     */
    public ListNode reverseList1(ListNode head) {
        ListNode prev = null;
        ListNode curr = head;
        while (curr != null) {
            ListNode next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;
        }
        return prev;
    }
}
