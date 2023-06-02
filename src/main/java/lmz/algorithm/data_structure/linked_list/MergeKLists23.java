package lmz.algorithm.data_structure.linked_list;

import lmz.algorithm.data_structure.linked_list.util.ListNode;

import java.util.PriorityQueue;

public class MergeKLists23 {
    /**
     * 分治合并：O(knlogn)
     */
    public ListNode mergeKLists(ListNode[] lists) {
        //0 <= len <= 10^4
        if (lists.length == 0) {
            return null;
        }
        return merge(lists, 0, lists.length - 1);
    }

    private ListNode merge(ListNode[] lists, int left, int right) {
        if (left > right) {
            return null;
        }
        if (left == right) {
            return lists[left];
        }
        int mid = (right - left) / 2 + left;
        return mergeTwoLists(merge(lists, left, mid - 1), merge(lists, mid + 1, right));
    }

    public ListNode mergeTwoLists(ListNode a, ListNode b) {
        if (a == null || b == null) {
            return a != null ? a : b;
        }
        ListNode head = new ListNode(0);
        ListNode tail = head, aPtr = a, bPtr = b;
        while (aPtr != null && bPtr != null) {
            if (aPtr.val < bPtr.val) {
                tail.next = aPtr;
                aPtr = aPtr.next;
            } else {
                tail.next = bPtr;
                bPtr = bPtr.next;
            }
            tail = tail.next;
        }
        tail.next = (aPtr != null ? aPtr : bPtr);
        return head.next;
    }

    /**
     * 利用最小堆：O(knlogn)
     */
    public ListNode mergeKLists2(ListNode[] lists) {
        //0 <= len <= 10^4
        if (lists.length == 0) {
            return null;
        }
        PriorityQueue<ListNode> heap = new PriorityQueue<>((a, b) -> a.val - b.val);
        for (ListNode node : lists) {
            heap.add(node);
        }
        ListNode dummyHead = new ListNode(); //哑结点便于操作
        ListNode cur = dummyHead;
        while (!heap.isEmpty()) {
            ListNode minNode = heap.poll();
            if (minNode.next != null) {
                heap.add(minNode.next);
            }
            cur.next = minNode;
            cur = cur.next;
        }
        cur.next = null;
        return dummyHead.next;
    }

    /**
     * 暴力合并，O(k*n*k)
     */
    public ListNode mergeKLists1(ListNode[] lists) {
        //0 <= len <= 10^4
        if (lists.length == 0) {
            return null;
        }
        int len = lists.length;
        ListNode dummyHead = new ListNode(); //哑结点便于操作
        ListNode cur = dummyHead;
        while (true) {
            int minIndex = -1;
            boolean allNull = true;
            for (int j = 0; j < len; j++) {
                if (lists[j] == null) {
                    continue;
                }
                allNull = false;
                if (minIndex == -1) {
                    minIndex = j;
                } else if (lists[minIndex].val > lists[j].val) {
                    minIndex = j;
                }
            }
            if (allNull) {
                break;
            }
            cur.next = lists[minIndex];
            cur = cur.next;
            lists[minIndex] = lists[minIndex].next;
        }
        cur.next = null;
        return dummyHead.next;
    }
}
