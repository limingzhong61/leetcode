package lmz.algorithm.data_structure.linked_list;

import lmz.algorithm.data_structure.linked_list.util.ListNode;

public class SwapPairs24 {
    public ListNode swapPairs(ListNode head) {
    //    0 <= Node.val <= 100
        if(head == null || head.next == null){
            return head;
        }
        ListNode dummyHead = new ListNode();
        dummyHead.next = head;
        ListNode pre = dummyHead,cur = head;
        while( cur != null && cur.next != null){
            ListNode next = cur.next;
            cur.next = next.next;
            next.next = cur;
            pre.next = next;
            pre = cur; //交换后，cur为两个结点中的后一个结点
            cur = cur.next;
        }
        return dummyHead.next;
    }
}
