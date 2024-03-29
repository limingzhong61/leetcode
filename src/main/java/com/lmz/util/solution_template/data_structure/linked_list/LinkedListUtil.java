package com.lmz.util.solution_template.data_structure.linked_list;

import com.lmz.leetcode.practice.data_structure.linked_list.util.ListNode;

/**
 * 链表算法工具类
 * @author: limingzhong
 * @create: 2023-02-01 17:49
 */
public class LinkedListUtil {

    /**
     * 快慢指针找到链表中的中点
     * 偶数为中间两位中的后一位。
     */
    public static ListNode findMid(ListNode head) {
        ListNode fast = head, slow = head;
        while (fast != null) {
            fast = fast.next;
            if (fast == null) {
                return slow;
            }
            slow = slow.next;
            fast = fast.next;
        }
        return slow;
    }
    /**
     * 逆置链表
     * @param head
     * @return 逆置后的链表头结点
     */
    private ListNode reverseList(ListNode head) {
        ListNode prev = null,cur = head;
        while (cur != null) {
            ListNode next = cur.next;
            cur.next = prev;
            prev = cur;
            cur = next;
        }
        return prev;
    }

    /**
     * 获取链表长度
     * @param head 头结点有值
     * @return 链表长度
     */
    public static int length(ListNode head) {
        int len = 0;
        ListNode cur = head;
        while (cur != null) {
            len++;
            cur = cur.next;
        }
        return len;
    }


    /**
     * 按照升序归并两个单链表
     * 思路：归并
     */
    public static ListNode mergeTwoLists(ListNode list1, ListNode list2) {
        ListNode dummy = new ListNode(0); //哑结点(充当头结点)便于操作
        ListNode cur = dummy;
        while(list1 != null && list2 != null){
            if(list1.val < list2.val){
                cur.next = list1;
                cur = cur.next;
                list1 = list1.next;
            }else {
                cur.next = list2;
                cur = cur.next;
                list2 = list2.next;
            }
        }
        //处理剩余结点
        while (list1 != null){
            cur.next = list1;
            cur = cur.next;
            list1 = list1.next;
        }
        while (list2 != null){
            cur.next = list2;
            cur = cur.next;
            list2 = list2.next;
        }
        //尾结点处理
        cur.next = null;
        return  dummy.next;
    }
}
