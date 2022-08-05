package codeofli.leetcode.data_structure.linked_list;

/**
 * leetcode:
 * Definition for singly-linked list.
 */

public class ListNode {
    public int val;
    public ListNode next;

    ListNode() {
    }

    public ListNode(int val) {
        this.val = val;
    }

    ListNode(int val, ListNode next) {
        this.val = val;
        this.next = next;
    }
}
