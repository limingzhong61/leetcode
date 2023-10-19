package com.lmz.leetcode.practice.two_pointer.fast_and_slow.linked_list;


import com.lmz.leetcode.practice.data_structure.linked_list.util.ListNode;

public class MiddleNode876 {

    /**
     * 双指针
     */
    public ListNode middleNode(ListNode head) {
        //给定链表的结点数介于 1 和 100 之间。
        ListNode fast = head, slow = head;
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        return slow;
    }

    /**
     * 双指针
     */
    public ListNode middleNode2(ListNode head) {
        //给定链表的结点数介于 1 和 100 之间。
        ListNode fast = head.next, slow = head;
        while (fast != null) {
            slow = slow.next;
            fast = fast.next;
            if (fast != null) {
                fast = fast.next;
            }
        }
        return slow;
    }
}
