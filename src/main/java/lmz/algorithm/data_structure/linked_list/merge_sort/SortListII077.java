package lmz.algorithm.data_structure.linked_list.merge_sort;

import lmz.algorithm.data_structure.linked_list.ListNode;

/**
 * 链表归并排序
 *
 * @author: limingzhong
 * @create: 2023-03-24 10:18
 */
public class SortListII077 {
    /**
     * 归并排序
     * 自底向上 bottom to up
     * time O( nlogn) ; space O(1)
     */
    public ListNode sortList(ListNode head) {
        int len = length(head);
        ListNode dummyHead = new ListNode(0);
        dummyHead.next = head;
        for (int cutLen = 1; cutLen < len; cutLen *= 2) {
            ListNode prev = dummyHead, cur = dummyHead.next;
            while (cur != null) {
                ListNode h1 = cur;
                //截取cutLen
                for (int i = 1; i < cutLen && cur.next != null; i++) {
                    cur = cur.next;
                }
                // no need to merge because the `h2` is None.
                ListNode h2 = cur.next;
                // 断链，h1---cur形成链表
                cur.next = null;

                cur = h2;
                if(cur != null){
                    for (int i = 1; i < cutLen && cur.next != null; i++) {
                        cur = cur.next;
                    }
                }


                ListNode next = null;
                if (cur != null) {
                    next = cur.next;
                    cur.next = null;
                }

                ListNode merged = mergeTwoLists(h1, h2);
                prev.next = merged;
                while (prev.next != null) {
                    prev = prev.next;
                }
                cur = next;
            }
        }
        return dummyHead.next;
    }

    /**
     * 获取链表长度
     *
     * @param head 头结点有值
     * @return 链表长度
     */
    private int length(ListNode head) {
        int len = 0;
        ListNode cur = head;
        while (cur != null) {
            len++;
            cur = cur.next;
        }
        return len;
    }

    /**
     * 链表中节点的数目在范围 [0, 5 * 10^4] 内
     * nlogn
     */
    public ListNode sortList1(ListNode head) {
        // 注意终止条件：当结点只有一个或者没有时直接返回
        if (head == null || head.next == null)
            return head;
        ListNode mid = findMid(head);
        //断开链表
        ListNode midHead = mid.next;
        mid.next = null;
        ListNode left = sortList1(head);
        ListNode right = sortList1(midHead);

        return mergeTwoLists(left, right);
    }

    /**
     * 快慢指针找到链表中的中点
     *
     * @param head 头结点有值
     * @return 链表中点；偶数为中间两位中的前一位。
     */
    private ListNode findMid(ListNode head) {
        if (head == null || head.next == null)
            return head;
        ListNode fast = head.next, slow = head;
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        return slow;
    }

    /**
     * 按照升序归并两个单链表
     * 思路：归并
     */
    public ListNode mergeTwoLists(ListNode list1, ListNode list2) {
        ListNode dummy = new ListNode(0); //哑结点(充当头结点)便于操作
        ListNode cur = dummy;
        while (list1 != null && list2 != null) {
            if (list1.val < list2.val) {
                cur.next = list1;
                cur = cur.next;
                list1 = list1.next;
            } else {
                cur.next = list2;
                cur = cur.next;
                list2 = list2.next;
            }
        }
        //处理剩余结点
        cur.next = list1 != null ? list1 : list2;
        return dummy.next;
    }
}
