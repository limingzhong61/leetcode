package lmz.my.leetcode.test_case;

import lmz.leetcode.other.old.everyday.Node;

/**
 * 链表
 */
public class CyclicLinkedList {
    /**
     * @param s ,格式：“[3,4,1]”
     * @return
     */
   public static Node StrToCyclicLinkedList(String s){
        String[] split = s.substring(1,s.length()-1).split(",");
        Node head = new Node(Integer.parseInt(split[0]));
        Node cur = head;
        for(int i = 1; i < split.length; i++){
            cur.next = new Node(Integer.parseInt(split[i]));
            cur = cur.next;
        }
        cur.next = head;
        return head;
    }

    /**
     * 循环链表
     * @param
     * @return ,格式：“[3,4,1]”
     */
    public static String CyclicLinkedListListToStr(Node head){
        StringBuilder sb = new StringBuilder();
        sb.append("[");
        if(head != null){
            sb.append(head.val).append(",");
        }
        Node cur = head.next;
        while(cur != head){
            sb.append(cur.val).append(",");
            cur = cur.next;
        }
        if(sb.toString().equals("")){
            return "";
        }
        sb.deleteCharAt(sb.length()-1).append("]");
        return sb.toString();
    }
}
