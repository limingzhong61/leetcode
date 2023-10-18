package com.lmz.algorithm_practice.data_structure.linked_list;

import com.lmz.algorithm_practice.data_structure.linked_list.util.ListNode;

import java.util.ArrayList;
import java.util.List;

/**
 * @author: limingzhong
 * @create: 2023-02-01 16:46
 */
public class AddTwoNumbersII025 {
    /**
     * 方法一：思路，直接用数组记录原链表的值，然后相加
     * 如果输入链表不能修改该如何处理？换句话说，不能对列表中的节点进行翻转
     * 链表的长度范围为 [1, 100]
     *
     *
     */
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode head = new ListNode(), p1 = l1, p2 = l2;
        List<Integer> a1 = new ArrayList<>(),a2 = new ArrayList<>();
        while(p1 != null){
            a1.add(p1.val);
            p1 = p1.next;
        }
        while(p2 != null){
            a2.add(p2.val);
            p2 = p2.next;
        }
        int val = 0;
        for(int i = a1.size() - 1,j = a2.size() -1; i >= 0 || j >= 0 || val != 0; i--, j--){
            int valI = i >= 0 ? a1.get(i) : 0;
            int valJ = j >= 0 ? a2.get(j) : 0;
            val += valI + valJ;

            ListNode newNode = new ListNode(val % 10);
            newNode.next = head.next;
            head.next = newNode;
            val /= 10;
        }
        return head.next;
    }
}
