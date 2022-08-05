package codeofli.leetcode.primary.linked_list;

import codeofli.leetcode.data_structure.linked_list.ListNode;

public class DeleteNode237 {
    /**
     * 给定当前结点指针，删除当前结点
     * 思路：与下一个结点交换值，删除下一个结点
     * @param node
     */
    public void deleteNode(ListNode node) {
        node.val = node.next.val;
        node.next = node.next.next;
    }
}
