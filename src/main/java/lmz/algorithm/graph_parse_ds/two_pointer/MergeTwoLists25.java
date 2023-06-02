package lmz.algorithm.graph_parse_ds.two_pointer;

import lmz.algorithm.data_structure.linked_list.util.ListNode;

public class MergeTwoLists25 {
    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        ListNode dummyHead = new ListNode(-1);
        ListNode cur = dummyHead, cur1 = l1, cur2 = l2;
        while (cur1 != null && cur2 != null) {
            if (cur1.val <= cur2.val) {
                cur.next = cur1;
                cur1 = cur1.next;
            } else {
                cur.next = cur2;
                cur2 = cur2.next;
            }
            cur= cur.next;
        }
        if(cur1 != null) cur.next = cur1;
        if(cur2 != null) cur.next = cur2;
        return dummyHead.next;
    }

    public static void main(String[] args) {
        MergeTwoLists25 mergeTwoLists25 = new MergeTwoLists25();
        //mergeTwoLists25.mergeTwoLists(LinkedList.StrToLinkedList("1->2->4"),LinkedList.StrToLinkedList("1->3->4"));
    }
}
