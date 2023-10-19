package com.lmz.leetcode.practice.p.p_1000_2000;

import com.lmz.leetcode.practice.data_structure.linked_list.util.ListNode;

/**
 * @author: limingzhong
 * @create: 2023-08-16 10:18
 */
public class DeleteMiddle2095 {
    public ListNode deleteMiddle(ListNode head) {
        ListNode dummy = new ListNode(0,head);
        ListNode fast = head,slow = dummy;
        while(fast != null && fast.next != null){
            fast = fast.next.next;
            slow = slow.next;
        }
        // slow 为中点前驱；
        slow.next = slow.next.next;
        return dummy.next;
    }
}
