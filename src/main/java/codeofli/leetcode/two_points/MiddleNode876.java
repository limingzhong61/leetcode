package codeofli.leetcode.two_points;

//Definition for singly-linked list.
class ListNode {
    int val;
    ListNode next;

    ListNode() {
    }

    ListNode(int val) {
        this.val = val;
    }

    ListNode(int val, ListNode next) {
        this.val = val;
        this.next = next;
    }
}

public class MiddleNode876 {
    /**
     * 双指针
     */
    public ListNode middleNode(ListNode head) {
        //给定链表的结点数介于 1 和 100 之间。
        ListNode fast = head.next,slow = head;
        while(fast != null){
            slow = slow.next;
            fast =fast.next;
            if(fast != null){
                fast = fast.next;
            }
        }
        return  slow;
    }
}
