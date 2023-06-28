package lmz.algorithm.data_structure.linked_list;

import lmz.algorithm.data_structure.linked_list.util.ListNode;

public class SwapPairs24 {


    public ListNode swapPairs(ListNode head) {
        if(head == null ||head.next == null){
            return  head;
        }
        ListNode dummy = new ListNode(0,head);
        ListNode p = dummy,pre = dummy,cur = dummy.next;
        while (cur != null && cur.next != null){
            pre = cur;
            cur = cur.next;
            ListNode next= cur.next;

            p.next = cur;
            cur.next = pre;
            pre.next = next;    // 奇数情况
            p = pre;
            cur = next;
        }
        return  dummy.next;
    }



    public ListNode swapPairs1(ListNode head) {
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
