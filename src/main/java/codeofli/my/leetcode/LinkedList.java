package codeofli.my.leetcode;

import codeofli.leetcode.graph_parse_ds.two_pointer.ListNode;

import java.util.List;

public class LinkedList {
    /**
     * @param s ,格式：“1->2->4”
     * @return
     */
   public static ListNode StrToLinkedList(String s){
        String[] split = s.split("->");
        ListNode head = new ListNode(Integer.parseInt(split[0]));
        ListNode cur = head;
        for(int i = 0; i < split.length; i++){
            cur.next = new ListNode(Integer.parseInt(split[i]));
            cur = cur.next;
        }
        return cur;
    }
}
