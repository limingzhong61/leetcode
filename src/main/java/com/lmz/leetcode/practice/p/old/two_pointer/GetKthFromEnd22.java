package com.lmz.leetcode.practice.p.old.two_pointer;

import com.lmz.leetcode.practice.data_structure.linked_list.util.ListNode;

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
