package lmz.algorithm.data_structure.linked_list.delete;

import lmz.algorithm.data_structure.linked_list.util.ListNode;

public class DeleteNode237 {
    /**
     * 给定当前结点指针，删除当前结点
     * 思路：与下一个结点交换值，删除下一个结点
     * @param node 保证给定的节点 node 不是链表中的最后一个节点。
     */
    public void deleteNode(ListNode node) {
        node.val = node.next.val;
        node.next = node.next.next;
    }
}
