package com.lmz.algorithm_practice.data_structure.linked_list;

import com.lmz.algorithm_practice.data_structure.linked_list.util.ListNode;

import java.util.ArrayList;
import java.util.List;

public class IsPalindrome234 {
    /**
     * 进阶：你能否用 O(n) 时间复杂度和 O(1) 空间复杂度解决此题？
     */
    public boolean isPalindrome(ListNode head) {
        int size = getSize(head);
        int half = size / 2;
        // 翻转前半部分
        ListNode pre = null,cur = head;
        for(int i = 0; i < half; i++){
            ListNode next = cur.next;
            cur.next = pre;
            pre = cur;
            cur = next;
        }
        if(size % 2 == 1){ // 奇数跳过中间节点
            cur = cur.next;
        }
        // 此时pre为前一段链表的头结点
        for(;cur != null && cur.val == pre.val; cur = cur.next,pre = pre.next);
        return cur == null &&pre == null;
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


    /**
     * my:
     * 用list记录值，然后判断即可；
     * 时间：O(n),空间O(n)
     */
    public boolean isPalindrome1(ListNode head) {
        List list = new ArrayList();
        for (ListNode cur = head; cur != null; cur = cur.next) {
            list.add(cur);
        }
        for (int i = 0, j = list.size() - 1; i < j; i++, j--) {
            if (list.get(i) != list.get(j)) {
                return false;
            }
        }

        return true;
    }

    /**
     * 进阶：你能否用 O(n) 时间复杂度和 O(1) 空间复杂度解决此题？
     */
    public boolean isPalindrome2(ListNode head) {
        int size = 0;
        for (ListNode cur = head; cur != null; cur = cur.next) {
            size++;
        }
        int half = size / 2;

        ListNode preNode = null;
        ListNode cur = head;
        //处理前半部分，反向链接
        for (int i = 0; i < half; i++) {
            ListNode next = cur.next;
            cur.next = preNode;
            preNode = cur;
            cur = next;
        }
        if (size % 2 == 1) { //奇数。跳过中间结点
            cur = cur.next;
        }
        for (int i = 0; i < half; i++) {
            // preNode 为前半部分首结点
            if (cur.val != preNode.val) {
                return false;
            }
            cur = cur.next;
            preNode = preNode.next;
        }
        return true;
    }

    /**
     * leetcode:
     * 递归
     * 时间：O(n),空间O(n)
     */
    public ListNode frontNode; //全局变量

    public boolean isPalindrome3(ListNode head) {
        frontNode = head;
        return recursivelyCheck(head);
    }

    private boolean recursivelyCheck(ListNode currentNode) {
        if (currentNode == null) {
            return true;
        }
        //前面的已经判断错误
        if (!recursivelyCheck(currentNode.next)) {
            return false;
        }
        //不对称
        if (currentNode.val != frontNode.val) {
            return false;
        }
        frontNode = frontNode.next;
        return true;
    }
}
