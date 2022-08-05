package codeofli.leetcode.linkedList;

//Definition for singly-linked list.
public class ListNode {
    int val;
    public ListNode next;

    ListNode(int x) {
        val = x;
        next = null;
    }

    ListNode(int val, ListNode next) {
        this.val = val;
        this.next = next;
    }
}