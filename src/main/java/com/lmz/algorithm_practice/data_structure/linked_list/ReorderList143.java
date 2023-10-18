package com.lmz.algorithm_practice.data_structure.linked_list;

import com.lmz.algorithm_practice.data_structure.linked_list.util.ListNode;
import com.lmz.algorithm_learning.leetcode.TransformUtil;

public class ReorderList143 {
    public void reorderList(ListNode head) {
        // 找到中点
        ListNode dummy = new ListNode(-1,head);
        ListNode fast = dummy.next,slow = dummy;
        while(fast != null &&fast.next != null){
            fast = fast.next.next;
            slow = slow.next;
        }
        //slow 为中点的前驱节点
        ListNode tail1 = slow,head2 = slow.next;
        System.out.println(head2.val);
        // 逆置链表
        ListNode cur = head2,pre = null;
        while(cur != null){
            ListNode next = cur.next;
            cur.next = pre;
            pre = cur;
            cur = next;
        }

        // 将两个链表合成一个
        cur = dummy;
        head2 = pre;
        // System.out.printf("%d,%d\n",head.val,head2.val);
        while(head != null && head2 != null){
            System.out.printf("%d,%d\n",head.val,head2.val);
            cur.next = head;
            head = head.next;
            cur = cur.next;


            cur.next = head2;
            head2 = head2.next;
            cur = cur.next;
        }
        head = dummy.next;
        System.out.printf("------\n");
    }


    /**
     * leetcode:快慢指针求链表中点
     */
    public void reorderList2(ListNode head) {
        if (head == null) {
            return;
        }
        ListNode mid = middleNode(head);
        ListNode l1 = head;
        ListNode l2 = mid.next;
        mid.next = null;
        //逆置后半段
        l2 = reverseList(l2);
        mergeList(l1,l2);
    }
    /**
     * 快慢双指针
     */
    public ListNode middleNode(ListNode head) {
        ListNode slow = head, fast = head;
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        return slow;
    }
    public ListNode reverseList(ListNode head) {
        ListNode preNode = null;
        while (head != null){
            ListNode temp = head.next;
            head.next = preNode;
            preNode = head;
            head = temp;
        }
        return preNode; //preNode为尾结点
    }
    public void mergeList(ListNode l1, ListNode l2) {
        ListNode l1_tmp;
        ListNode l2_tmp;
        while (l1 != null && l2 != null) {
            l1_tmp = l1.next;
            l2_tmp = l2.next;

            l1.next = l2;
            l1 = l1_tmp;

            l2.next = l1;
            l2 = l2_tmp;
        }
    }

    public static void main(String[] args) {
        ReorderList143 reorderList143 = new ReorderList143();
        reorderList143.reorderList(TransformUtil.toLinkedList("[1,2,3,4]"));
    }

}
