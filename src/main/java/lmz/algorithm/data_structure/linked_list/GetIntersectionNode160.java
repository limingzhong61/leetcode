package lmz.algorithm.data_structure.linked_list;


import lmz.algorithm.data_structure.linked_list.util.ListNode;

import java.util.HashSet;
import java.util.Set;

public class GetIntersectionNode160 {
    /**
     * leetcode:双指针法
     * 两个链表长度设分别为m+n:
     * 两个指针共同遍历m+n,
     */
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        ListNode curA = headA,curB = headB;
        while(curA != curB){
            curA = curA == null ? headB : curA.next;
            curB = curB == null ? headA : curB.next;
        }
        return curA;
    }


    /**
     * leetcode:hash表
     */
    public ListNode getIntersectionNode2(ListNode headA, ListNode headB) {
        Set<ListNode> set = new HashSet<>();
        while(headA != null){
            set.add(headA);
            headA = headA.next;
        }
        while(headB != null){
            if(set.contains(headB)){
                return headB;
            }
            headB = headB.next;
        }
        return null;
    }




    public static void main(String[] args) {

    }
}
