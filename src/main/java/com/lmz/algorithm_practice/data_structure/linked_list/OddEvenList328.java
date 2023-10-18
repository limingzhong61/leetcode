package com.lmz.algorithm_practice.data_structure.linked_list;


import com.lmz.algorithm_practice.data_structure.linked_list.util.ListNode;

public class OddEvenList328 {

    /**
     * 迭代：两个哑结点处理
     * 从1开始
     * 注意：奇偶遍历，可以直接一次性进行两次操作（一奇一偶），不用判断奇偶。
     */
    public ListNode oddEvenList(ListNode head) {
        ListNode oddList = new ListNode(0);
        ListNode evenList = new ListNode(0);
        ListNode oddCur = oddList;
        ListNode evenCur = evenList;
        ListNode cur = head;
        int cnt = 1;
        while(cur != null){
            oddCur.next = cur;
            oddCur = cur;
            cur = cur.next;
            if(cur != null){
                evenCur.next = cur;
                evenCur = cur;
                cur = cur.next;
            }
        }
        // System.out.println(oddCur.val);
        //连接奇偶链表
        oddCur.next = evenList.next;
        evenCur.next = null;
        return oddList.next;
    }
}
