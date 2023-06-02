package lmz.algorithm.data_structure.linked_list.reverse;

import lmz.algorithm.data_structure.linked_list.util.ListNode;

/**
 * @author: limingzhong
 * @create: 2023-06-02 13:50
 */
public class ReverseBetween92II {
    /**
     * 遍历第2段逆置
     */
    public ListNode reverseBetween(ListNode head, int left, int right) {
        ListNode dummy = new ListNode(0, head);
        ListNode l1Tail = dummy;    //3段，第一段的尾巴
        for (int i = 1; i < left; i++) {
            l1Tail = l1Tail.next;
        }
        // System.out.println(l1Tail.val);
        // System.out.println(l1Tail.next.val);
        // 遍历第2段直接逆置
        ListNode cur = l1Tail.next;
        ListNode pre = null;
        for (int i = 0; i < right - left + 1; ++i) {
            ListNode next = cur.next;
            cur.next = pre; // 每次循环只修改一个 next，方便理解
            pre = cur;
            cur = next;
        }
        // System.out.println(l1Tail.next);
        // 遍历逆置后，pre为第2段逆置链表头节点 cur为第3段的头结点
        // 此时l1Tail还指向第2段逆置链表尾节点
        l1Tail.next.next = cur;
        l1Tail.next = pre;

        return dummy.next;
    }


    /**
     * 分3段逆置
     */
    public ListNode reverseBetween2(ListNode head, int left, int right) {
        ListNode dummy = new ListNode(0, head);
        ListNode cur = dummy;
        for (int i = 1; i < left; i++) {
            cur = cur.next;
        }
        ListNode l1Tail = cur; //3段，第一段的尾巴

        ListNode cur2 = cur.next;
        for (int i = left; i < right; i++) {
            cur2 = cur2.next;
        }
        ListNode l3 = cur2.next; // 第3段head
        cur2.next = null; // 断链，left--right 第二段


        // 逆置
        ListNode pre = null;
        cur = l1Tail.next;
        while (cur != null) {
            ListNode next = cur.next;
            cur.next = pre;
            pre = cur;
            cur = next;
        }
        l1Tail.next = pre;

        // 找到链表尾节点
        cur = l1Tail;
        while (cur.next != null) {
            cur = cur.next;
        }
        cur.next = l3;

        return dummy.next;
    }
}
