package codeofli.leetcode.contest.c321;

import codeofli.leetcode.data_structure.linked_list.ListNode;

import java.util.List;

public class RemoveNodes {
    ListNode dummyHead;

    public ListNode removeNodes(ListNode head) {
        dummyHead = new ListNode(-1);
        dfs(head);
        return dummyHead.next;
    }

    int max = Integer.MIN_VALUE;

    private void dfs(ListNode cur) {
        if (cur == null) {
            return;
        }
        if (cur.val >= max) {
            ListNode newNode = new ListNode(cur.val);
            newNode.next = dummyHead.next;
            dummyHead.next = newNode;
            max = cur.val;
        }
        cur = cur.next;
        dfs(cur);

    }
}
