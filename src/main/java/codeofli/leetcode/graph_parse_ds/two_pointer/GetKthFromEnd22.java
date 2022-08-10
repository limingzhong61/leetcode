package codeofli.leetcode.graph_parse_ds.two_pointer;

import codeofli.leetcode.data_structure.linked_list.ListNode;

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
