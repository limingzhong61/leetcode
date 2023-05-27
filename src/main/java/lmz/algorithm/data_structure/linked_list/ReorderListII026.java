package lmz.algorithm.data_structure.linked_list;

import java.util.ArrayList;
import java.util.List;

/**
 * @author: limingzhong
 * @create: 2023-02-01 17:13
 */
public class ReorderListII026 {
    /**
     * 方法一： 使用快慢指针求中点,逆置后半段，然后合并链表
     * 空间复杂度：O(1)
     *
     * 链表的长度范围为 [1, 5 * 104]
     */
    public void reorderList(ListNode head) {
        if(head == null){
            return;
        }
        ListNode mid = middleNode(head);
        ListNode l1 = head,l2 = mid.next;
        mid.next = null;
        l2 = reverseList(l2);
        mergeList(l1,l2);
    }

    public ListNode mergeList(ListNode l1, ListNode l2) {
        ListNode dummy = new ListNode(0); //哑结点(充当头结点)便于操作
        ListNode cur = dummy;
        while(l1 != null && l2 != null){
            cur.next = l1;
            l1 = l1.next;
            cur = cur.next;

            cur.next = l2;
            l2 = l2.next;
            cur = cur.next;
        }
        if(l1 != null){ // 奇数链表，前半段为奇数，多一个
            cur.next = l1;
            cur = cur.next;
        }
        //尾结点处理
        cur.next = null;
        return  dummy.next;
    }

    /**
     * 逆置链表
     * @param head
     * @return
     */
    private ListNode reverseList(ListNode head) {
        ListNode prev = null,cur = head;
        while (cur != null) {
            ListNode next = cur.next;
            cur.next = prev;
            prev = cur;
            cur = next;
        }
        return prev;
    }

    /**
     * 快慢指针找到链表中的中点
     * 偶数为中间两位中的后一位。
     */
    private ListNode middleNode(ListNode head) {
        ListNode fast = head, slow = head;
        while (fast.next != null && fast.next.next != null) {
            fast = fast.next.next;
            slow = slow.next;
        }
        return slow;
    }

    /**
     * 方法一： 使用array结构记录
     * 链表的长度范围为 [1, 5 * 104]
     */
    public void reorderList1(ListNode head) {
        ListNode dummyHead = new ListNode(), p = head;
        List<ListNode> arrayList = new ArrayList<>();
        while (p != null) {
            arrayList.add(p);
            p = p.next;
        }
        p = dummyHead;
        int i = 0, j = arrayList.size() - 1;
        for (; i < j; i++, j--) {
            p.next = arrayList.get(i);
            p = p.next;
            p.next = arrayList.get(j);
            p = p.next;
        }
        if (i == j) {
            p.next = arrayList.get(i);
            p = p.next;
        }
        p.next = null;
        head = dummyHead.next;
    }
}
