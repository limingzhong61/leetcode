package lmz.my.solution_template.sort.linked_list;

import lmz.algorithm.data_structure.linked_list.util.ListNode;
import lmz.my.solution_template.data_structure.linked_list.LinkedListUtil;

import static lmz.my.solution_template.data_structure.linked_list.LinkedListUtil.mergeTwoLists;

/**
 * @author: limingzhong
 * @create: 2023-03-24 10:54
 */
public class MergeSort {
    /**
     * 归并排序：自顶向下
     * 链表中节点的数目在范围 [0, 5 * 10^4] 内
     * nlogn
     */
    public ListNode mergeSortList(ListNode head) {
        // 注意终止条件：当结点只有一个或者没有时直接返回
        if (head == null || head.next == null)
            return head;
        ListNode mid = LinkedListUtil.findMid(head);
        //断开链表
        ListNode midHead = mid.next;
        mid.next = null;
        ListNode left = mergeSortList(head);
        ListNode right = mergeSortList(midHead);

        return mergeTwoLists(left, right);
    }

    /**
     * 归并排序
     * 自底向上 bottom to up
     * time O( nlogn) ; space O(1)
     */
    public ListNode mergeSortList0(ListNode head) {
        int len = LinkedListUtil.length(head);
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
}
