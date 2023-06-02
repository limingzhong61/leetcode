package lmz.algorithm.graph_parse_ds.two_pointer;

import lmz.algorithm.data_structure.linked_list.util.ListNode;

public class GetKthFromEnd22 {
    public ListNode getKthFromEnd(ListNode head, int k) {
        ListNode fast = head,slow = head;
        while(k-- != 0){
            fast = fast.next;
        }
        while(fast != null){
            fast = fast.next;
            slow = slow.next;
        }
        return slow;
    }
}
