package lmz.algorithm.other.medium.old;

import lmz.algorithm.data_structure.linked_list.ListNode;

/**
 * @author: limingzhong
 * @create: 2023-01-30 11:32
 */
public class MergeInBetween1669 {
    public ListNode mergeInBetween(ListNode list1, int a, int b, ListNode list2) {
        ListNode p = list1, pa = null, pb = null;
        for (int i = 0; i <= b; i++) {
            if (i == a - 1) {
                pa = p;
            }
            p = p.next;
        }
        pb = p;
        pa.next = list2;
        p = list2;
        while (p.next != null) {
            p = p.next;
        }
        p.next = pb;
        return list1;
    }
}
