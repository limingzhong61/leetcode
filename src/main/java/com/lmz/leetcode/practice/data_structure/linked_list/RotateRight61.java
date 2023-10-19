package com.lmz.leetcode.practice.data_structure.linked_list;


import com.lmz.leetcode.practice.data_structure.linked_list.util.ListNode;

public class RotateRight61 {
    /**
     *
     * 获取链表长度length;
     * 在length-k处断开，后面一段置于前面一段即可
     */
    public ListNode rotateRight(ListNode head, int k) {
        int length = 0;
        ListNode cur = head;
        ListNode tail = head;
        while (cur != null){
            length++;
            tail = cur;
            cur = cur.next;
        }
        k %= length;
        // 0不需要旋转
        if(k == 0){
            return head;
        }
        int moveLength = length - k;
        cur = head;
        //找到断开位置前一个结点
        moveLength--;
        while(moveLength != 0){
            moveLength--;
            cur = cur.next;
        }
        tail.next = head;
        head = cur.next;
        cur.next = null;
        return head;
    }
}
