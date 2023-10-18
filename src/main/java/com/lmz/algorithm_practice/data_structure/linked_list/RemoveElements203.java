package com.lmz.algorithm_practice.data_structure.linked_list;


import com.lmz.algorithm_practice.data_structure.linked_list.util.ListNode;

public class RemoveElements203 {
    /**
     * 递归：
     */
    public ListNode removeElements(ListNode head, int val) {
        if(head == null){
            return null;
        }
        head.next = removerRecur(head.next,val);
        return head.val == val ? head.next : head;
    }

    private ListNode removerRecur(ListNode head, int val) {
        if(head == null){
            return null;
        }
        ListNode next = removeElements(head.next, val);
        if(next.val == val){
            head.next = next.next;
        }
        return head;
    }

    /**
     * 迭代：添加头结点方便处理
     */
    public ListNode removeElements1(ListNode head, int val) {
        ListNode dummyHead = new ListNode(0);
        ListNode cur = dummyHead;
        cur.next = head;
        while(cur.next != null){
            if(cur.next.val == val){
                cur.next = cur.next.next;
            }else{
                cur = cur.next;
            }
        }
        return dummyHead.next;
    }
}
