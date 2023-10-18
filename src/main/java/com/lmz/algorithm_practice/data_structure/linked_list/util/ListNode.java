package com.lmz.algorithm_practice.data_structure.linked_list.util;

/**
 * leetcode:
 * Definition for singly-linked list.
 */

public class ListNode {
    public int val;
    public ListNode next;

    public ListNode() {
    }

    public ListNode(int val) {
        this.val = val;
    }

    public ListNode(int val, ListNode next) {
        this.val = val;
        this.next = next;
    }

    @Override
    public String toString(){
        StringBuilder sb = new StringBuilder();
        sb.append("[").append(this.val);
        ListNode cur = next;
        while(cur != null){
            sb.append(",").append(cur.val);
            cur = cur.next;
        }
        sb.append("]");
        return sb.toString();
    }
}
