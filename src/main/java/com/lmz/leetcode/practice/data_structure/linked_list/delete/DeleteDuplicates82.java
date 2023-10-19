package com.lmz.leetcode.practice.data_structure.linked_list.delete;


import com.lmz.leetcode.practice.data_structure.linked_list.util.ListNode;

public class DeleteDuplicates82 {
    /**
     * 两个指针 pre,cur
     */
    public ListNode deleteDuplicates(ListNode head) {
        ListNode dummy = new ListNode(0,head);
        ListNode cur = dummy.next,pre = dummy;
        while (cur!= null){

           if(cur.next != null && cur.val == cur.next.val ){
               // cur 为相同节点的尾部
               while(cur.next != null && cur.val == cur.next.val ){
                   cur = cur.next;
               }
               cur = cur.next;
               pre.next = cur.next;
           }else{
               pre = cur ;
               cur = cur.next;
           }
        }
        return dummy.next;
    }

}
