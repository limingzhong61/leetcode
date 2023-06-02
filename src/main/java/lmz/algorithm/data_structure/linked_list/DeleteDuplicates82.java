package lmz.algorithm.data_structure.linked_list;


import lmz.algorithm.data_structure.linked_list.util.ListNode;

public class DeleteDuplicates82 {
    /**
     * 双指针
     */
    public ListNode deleteDuplicates(ListNode head) {
        ListNode dummyHead = new ListNode(-1);
        dummyHead.next = head;
        ListNode pre = dummyHead;
        ListNode cur = head;
        while(cur != null && cur.next != null){
            if(cur.val != cur.next.val){ // cur结点不重复
                pre = cur;
                cur = cur.next;
            }else{ // cur结点重复
                while( cur.next != null && cur.val == cur.next.val){
                    cur.next = cur.next.next; // 移除重复的cur.next
                }
                pre.next = cur.next; // 删除cur
                cur = pre.next; //cur后移
            }
        }
        return dummyHead.next;
    }
}
