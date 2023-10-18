package com.lmz.algorithm_practice.other.old.two_pointer;


import com.lmz.algorithm_practice.data_structure.linked_list.util.ListNode;

public class DeleteNode18 {
    /**
     * 添加哑结点
     */
    public ListNode deleteNode(ListNode head, int val) {
        ListNode dummyHead = new ListNode(-1);
        dummyHead.next = head;
        ListNode cur = dummyHead;
        while (cur.next != null && cur.next.val != val){
            cur = cur.next;
        }
        //cur不是尾结点
        if(cur.next != null){
            cur.next = cur.next.next;
        }
        return dummyHead.next;
    }
}
