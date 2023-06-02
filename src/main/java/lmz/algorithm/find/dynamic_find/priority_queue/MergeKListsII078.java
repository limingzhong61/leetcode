package lmz.algorithm.find.dynamic_find.priority_queue;

import lmz.algorithm.data_structure.linked_list.util.ListNode;

import java.util.PriorityQueue;

public class MergeKListsII078 {
    public ListNode mergeKLists(ListNode[] lists) {
        PriorityQueue<ListNode> pq = new PriorityQueue<>((a,b) -> a.val - b.val);
        for(var list : lists){
            if(list != null)
                pq.add(list);
        }
        ListNode dummyHead = new ListNode(0);
        ListNode cur =dummyHead;
        while(!pq.isEmpty()){
            ListNode node = pq.poll();
            if(node.next != null){
                pq.add(node.next);
            }
            node.next = cur.next;
            cur.next = node;
            cur = cur.next;
        }
        return dummyHead.next;
    }
}
