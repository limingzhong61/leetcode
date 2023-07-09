package com.lmz.algorithm.other.old.two_pointer;

import com.lmz.algorithm.data_structure.linked_list.util.ListNode;

public class GetKthFromEnd22 {
    public ListNode getKthFromEnd(ListNode head, int k) {
        ListNode fast = head,slow = head;
        while(k-- != 0){
            fast = fast.next;
        }
        while(fast != null){
            fast = fast.next;
            slow = slow.next;
        }
        return slow;
    }
}
