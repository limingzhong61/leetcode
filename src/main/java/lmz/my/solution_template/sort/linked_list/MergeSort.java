package lmz.my.solution_template.sort.linked_list;

import lmz.leetcode.data_structure.linked_list.ListNode;

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
        ListNode mid = findMid(head);
        //断开链表
        ListNode midHead = mid.next;
        mid.next = null;
        ListNode left = mergeSortList(head);
        ListNode right = mergeSortList(midHead);

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
