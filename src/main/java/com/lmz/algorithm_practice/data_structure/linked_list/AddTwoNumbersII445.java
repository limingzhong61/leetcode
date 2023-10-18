package com.lmz.algorithm_practice.data_structure.linked_list;

import com.lmz.algorithm_practice.data_structure.linked_list.util.ListNode;

import java.util.Deque;
import java.util.LinkedList;

public class AddTwoNumbersII445 {
    /**
     * 用栈遍历链表，然后相加形成链表
     */
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {

        ListNode dummyHead = new ListNode(0, null);
        ListNode cur = dummyHead;
        Deque<Integer> stack1 = getStack(l1);
        Deque<Integer> stack2 = getStack(l2);
        int carry = 0;
        while (!stack1.isEmpty() || !stack2.isEmpty() || carry != 0) {
            int x = stack1.isEmpty() ? 0 : stack1.pop();
            int y = stack2.isEmpty() ? 0 : stack2.pop();
            int sum = x + y + carry;
            ListNode newNode = new ListNode(sum % 10, dummyHead.next);
            dummyHead.next = newNode;
            carry = sum / 10;
        }
        return dummyHead.next;
    }

    private Deque<Integer> getStack(ListNode l1) {
        Deque<Integer> stack = new LinkedList<>();
        ListNode cur = l1;
        while (cur != null){
            stack.push(cur.val);
            cur = cur.next;
        }
        return  stack;
    }

    /**
     * 逆置l1,l2,然后相加，逆置结果
     */
    public ListNode addTwoNumbers1(ListNode l1, ListNode l2) {

        ListNode dummyHead = new ListNode(0, null);
        ListNode cur = dummyHead;
        ListNode cur1 = reverseList(l1), cur2 = reverseList(l2);
        int carry = 0;
        while (cur1 != null || cur2 != null || carry != 0) {
            int x = cur1 == null ? 0 : cur1.val;
            int y = cur2 == null ? 0 : cur2.val;
            int sum = x + y + carry;
            ListNode newNode = new ListNode(sum % 10, null);
            cur.next = newNode;
            cur = newNode;
            carry = sum / 10;
            if (cur1 != null) {
                cur1 = cur1.next;
            }
            if (cur2 != null) {
                cur2 = cur2.next;
            }
        }
        return reverseList(dummyHead.next);
    }

    /**
     * my:迭代逆置
     */
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

}
