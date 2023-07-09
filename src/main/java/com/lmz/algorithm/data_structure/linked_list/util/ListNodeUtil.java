package com.lmz.algorithm.data_structure.linked_list.util;

/**
 * 链表工具类
 * @author: limingzhong
 * @create: 2023-06-02 15:09
 */
public class ListNodeUtil {

    /**
     * 迭代逆置链表
     * @param head
     * @return 逆置后的链表头结点
     */
    public ListNode reverse(ListNode head) {
        ListNode pre = null;
        ListNode cur = head;
        while(cur != null){
            ListNode next = cur.next;
            cur.next = pre;
            pre = cur;
            cur = next;
        }
        return pre;
    }

    /**
     * 双指针
     * @param head
     * @Return 中间节点，奇数为正中间，偶数为中间两个的后一位
     */
    public ListNode middleNode(ListNode head) {
        //给定链表的结点数介于 1 和 100 之间。
        ListNode fast = head, slow = head;
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        return slow;
    }

    /**
     * 给定一个已排序的链表的头 head ， 删除所有重复的元素，使每个元素只出现一次 。
     */
    public ListNode deleteDuplicates(ListNode head) {
        ListNode cur = head;
        while(cur != null){
            if(cur.next != null && cur.val == cur.next.val){
                cur.next = cur.next.next;
                continue;
            }
            cur = cur.next;
        }
        return  head;
    }

    /**
     * 合并两个有序链表
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
     * 获取链表的长度
     *
     * @param head
     * @return 链表长度
     */
    private int getSize(ListNode head) {
        int size = 0;

        for (ListNode cur = head; cur != null; cur = cur.next) {
            size++;
        }
        return size;
    }

    void print(ListNode list) {
        System.out.println(list.toString());
    }
}
