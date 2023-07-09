package com.lmz.algorithm.data_structure.linked_list;

import com.lmz.algorithm.data_structure.linked_list.util.ListNode;

import java.util.ArrayList;

/**
 * @author: limingzhong
 * @create: 2023-05-27 21:11
 */
public class ReverseBetweenNC21 {
    /**
     *中间利用头插入法翻转
     * @param head ListNode类
     * @param m int整型
     * @param n int整型
     * @return ListNode类
     */
    public ListNode reverseBetween (ListNode head, int m, int n) {
        // write code here
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        ListNode p = dummy;
        for(int i = 1; i < m; i++){ //找m的前驱
            p = p.next;
        }
        System.out.println(p.val);
        ListNode q = p.next;
        p.next = null; // 0--m 的链表
        ArrayList<ListNode> list = new ArrayList<>();
        for(int i = 0; i <= n - m; i++){  // 需要翻转的区域
            ListNode next = q.next;
            q.next = p.next;
            p.next = q;
            q = next;
        }
        //q.next = r;
        //System.out.println(q.val);
        //ListNode r = q; // n的后继

        //p.next = r;
        return dummy.next;
    }

    /**
     *中间利用list翻转
     * @param head ListNode类
     * @param m int整型
     * @param n int整型
     * @return ListNode类
     */
    public ListNode reverseBetween2 (ListNode head, int m, int n) {
        // write code here
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        ListNode p = dummy;
        for(int i = 1; i < m; i++){ //找m的前驱
            p = p.next;
        }
        System.out.println(p.val);
        ListNode q = p.next;
        ArrayList<ListNode> list = new ArrayList<>();
        for(int i = 0; i <= n - m; i++){
            list.add(q);
            q = q.next;
        }
        System.out.println(q.val);
        ListNode r = q; // n的后继
        for(int i = list.size() - 1; i >= 0; i--){
            p.next = list.get(i);
            p = p.next;
        }

        p.next = r;
        return dummy.next;
    }
}
