package com.lmz.leetcode.practice.p.old.everyday;


import com.lmz.leetcode.practice.data_structure.linked_list.lc_structure.Node;
import com.lmz.algorithm_learning.leetcode.test_case.CyclicLinkedList;

public class Insert29 {
    /**
     * undo
     * 官方：一次遍历
     */
    public Node insert(Node head, int insertVal) {
        Node node = new Node(insertVal);
        if (head == null) {
            node.next = node;
            return node;
        }
        if (head.next == head) {
            head.next = node;
            node.next = head;
            return head;
        }
        Node curr = head, next = head.next;
        while (next != head) {
            if (insertVal >= curr.val && insertVal <= next.val) {
                break;
            }
            if (curr.val > next.val) {
                if (insertVal > curr.val || insertVal < next.val) {
                    break;
                }
            }
            curr = curr.next;
            next = next.next;
        }
        curr.next = node;
        node.next = next;
        return head;
    }
    /**
     * undo
     * leetcode:先找真正的头节点（最小值），再找插入位置，再插入元素
     */
    public Node insert3(Node head, int insertVal) {
        Node cur = null;
        Node next = null;
        Node realHead = null;
        //空的
        if(head == null){
            head = new Node(insertVal);
            head.next = head;
            return head;
        }

        //找到真正的头节点
        cur = head;
        next = head.next;
        while(cur.val <= next.val){
            cur = cur.next;
            next = next.next;
            if(cur == head) break;
        }
        realHead = next;

        //找插入位置
        while(next.val < insertVal){
            cur = next;
            next = next.next;
            //相等了，就随便插
            if(next == realHead)break;
        }
        //连接
        cur.next = new Node(insertVal);
        cur = cur.next;
        cur.next = next;
        return head;
    }
    /**
     * 方法一：遍历一遍，直接硬插入
     * 因为是循环链表，所以遍历结束条件为 cur == head;
     */
    public Node insert2(Node head, int insertVal) {
        if (head == null) {
            //返回必须是循环链表
            head = new Node(insertVal, null);
            head.next = head;
            return head;
        }
        Node cur = head;
        boolean skipHalf = false;
        //小于当前头结点，则应该插在后半部分
        if (insertVal <= cur.val) {
            skipHalf = true;
        }
        //保重非递减，非递减是<=
        while (cur.next != head && cur.val <= cur.next.val) {
            //找到插入位置，已经插入成功
            if (!skipHalf && insertVal <= cur.next.val) {
                Node node = new Node(insertVal);
                node.next = cur.next;
                cur.next = node;
                return head;
            }
            cur = cur.next;
        }
        //没有找到比insertVal大于等于的结点
        if (cur.next == head) {
            Node node = new Node(insertVal);
            node.next = cur.next;
            cur.next = node;
        } else { //后一节升序结点
            //insertVal 最大
            if (!skipHalf && insertVal >= cur.next.val) {
                Node node = new Node(insertVal);
                node.next = cur.next;
                cur.next = node;
                return head;
            }
            //在后一节中插入
            while (cur.next != head) {
                if (insertVal <= cur.next.val) {
                    Node node = new Node(insertVal);
                    node.next = cur.next;
                    cur.next = node;
                    return head;
                }
                cur = cur.next;
            }
            //没有找到比insertVal小的结点,且当前结点为尾结点
            Node node = new Node(insertVal);
            node.next = cur.next;
            cur.next = node;
        }
        return head;
    }

    public static void main(String[] args) {
        Insert29 insert29 = new Insert29();
        System.out.println(CyclicLinkedList.CyclicLinkedListListToStr(
                insert29.insert(CyclicLinkedList.StrToCyclicLinkedList("[3,4,1]"), 2)));
        System.out.println(CyclicLinkedList.CyclicLinkedListListToStr(
                insert29.insert(CyclicLinkedList.StrToCyclicLinkedList("[3,4,1]"), 2)).equals("[3,4,1,2]"));
    }
}
