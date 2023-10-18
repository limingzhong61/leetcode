package com.lmz.algorithm_learning.leetcode;

import com.lmz.algorithm_practice.data_structure.linked_list.util.ListNode;

/**
 * 链表
 */
public class CyclicLinkedList {
    /**
     * @param s ,格式：“[3,4,1]”
     * @return
     */
   public static ListNode StrToCyclicLinkedList(String s){
        String[] split = s.substring(1,s.length()-1).split("->");
        ListNode head = new ListNode(Integer.parseInt(split[0]));
        ListNode cur = head;
        ListNode tail = cur;
        for(int i = 1; i < split.length; i++){
            cur.next = new ListNode(Integer.parseInt(split[i]));
            tail =cur;
            cur = cur.next;
        }
        tail.next = head;
        return head;
    }

    /**
     * 循环链表
     * @param
     * @return ,格式：“[3,4,1]”
     */
    public static String CyclicLinkedListListToStr(ListNode head){
        StringBuilder sb = new StringBuilder();
        sb.append("[");
        ListNode cur = head;
        while(cur != null){
            sb.append(cur.val).append(",");
            cur = cur.next;
        }
        if(sb.toString().equals("")){
            return "";
        }
        sb.delete(sb.length()-2,sb.length());
        return sb.append("]").toString();
    }
}
