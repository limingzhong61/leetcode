package com.lmz.algorithm_practice.other.old.two_pointer;

import com.lmz.algorithm_practice.data_structure.linked_list.util.ListNode;

public class GetIntersectionNode52 {
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        ListNode A = headA, B = headB;
        while (A != B) {
            A = A != null ? A.next : headB;
            B = B != null ? B.next : headA;
        }
        return A;
    }

    public ListNode getIntersectionNode1(ListNode headA, ListNode headB) {
        int lenA = getLength(headA);
        int lenB = getLength(headB);
        int k;
        ListNode bigCur, smallCur;
        if (lenA > lenB) {
            k = lenA - lenB;
            bigCur = headA;
            smallCur = headB;
        }else {
            k = lenB - lenA;
            bigCur = headB;
            smallCur = headA;
        }
        for (int i = 0; i < k; i++) {
            bigCur = bigCur.next;
        }
        while(bigCur != smallCur){
            bigCur = bigCur.next;
            smallCur = smallCur.next;
        }
        return bigCur;
    }

    private int getLength(ListNode headA) {
        ListNode cur = headA;
        int cnt = 0;
        while (cur != null) {
            cnt++;
            cur = cur.next;
        }
        return cnt;
    }
}
