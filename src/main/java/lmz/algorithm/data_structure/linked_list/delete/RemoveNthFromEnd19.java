package lmz.algorithm.data_structure.linked_list.delete;

import lmz.algorithm.data_structure.linked_list.util.ListNode;

public class RemoveNthFromEnd19 {

    /**
     * my
     * 关键在于找到倒数第n个结点的前一个结点:
     * 双指针,两个指针间隔倒数的个数
     */
    public ListNode removeNthFromEnd1(ListNode head, int n) {
        ListNode fast = head;

        //移动n次
        for(int i = 0; i < n && fast != null; i++){
            fast = fast.next;
        }
        //删除头结点,此时倒数n结点的父节点为头结点
        if(fast == null){
            head = head.next;
            return head;
        }
        ListNode slow = head;
        ListNode parent = null;
        while(fast != null){
            fast = fast.next;
            parent = slow;
            slow = slow.next;
        }
        //此时 parent 为倒数n结点的父节点
        parent.next = parent.next.next;
        return  head;
    }

    /**
     * leetCode
     * 对于没有头结点的链表，添加一个哑结点（当做头结点），便于删除操作
     */
    public ListNode removeNthFromEnd2(ListNode head, int n) {
        ListNode dummy  = new ListNode(0);
        ListNode fast = dummy;
        ListNode slow = dummy;
        //移动n+1次
        for(int i = 0; i <= n && fast != null; i++){
            fast = fast.next;
        }
        while(fast != null){
            fast = fast.next;
            slow = slow.next;
        }
        //此时 slow 为倒数n结点的父节点
        slow.next = slow.next.next;
        ListNode result = dummy.next;
        return  result;
    }
    /**
     * leetCode评论
     * 递归删除链表
     */
    int cnt = 0;
    public ListNode removeNthFromEnd(ListNode head, int n) {
        if(head == null) return null;
        head.next = removeNthFromEnd(head.next,n);
        cnt++;
        if(cnt == n){ //head为倒数n个结点
            return head.next;
        }
        return head;
    }
}
