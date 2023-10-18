package com.lmz.algorithm_practice.data_structure.linked_list;

import com.lmz.algorithm_practice.data_structure.linked_list.util.ListNode;

public class MergeTwoLists21 {
    /**
     * 思路：归并
     */
    public ListNode mergeTwoLists(ListNode list1, ListNode list2) {
        ListNode dummy = new ListNode(0);
        ListNode p1 = list1,p2 = list2,p = dummy;
        while(p1 != null && p2 != null){
            if(p1.val < p2.val){
                p.next = p1;
                p1 = p1.next;
            }else{
                p.next = p2;
                p2 = p2.next;
            }
            p= p.next;
        }
        if(p1 == null){
            p.next = p2;
        }else{
            p.next = p1;
        }
        return dummy.next;
    }

    /**
     * my:
     * 思路：递归合并
     */
    public ListNode mergeTwoLists2(ListNode list1, ListNode list2) {
        if(list1 == null){
            return list2;
        }else if(list2 == null){
            return list1;
        }
        if(list1.val < list2.val){
            list1.next = mergeTwoLists(list1.next,list2);
            return list1;
        }else{
            list2.next = mergeTwoLists(list1,list2.next);
            return list2;
        }
    }
}
