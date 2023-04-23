package lmz.leetcode.two_pointer.fast_and_slow;




import lmz.leetcode.data_structure.linked_list.ListNode;

import java.util.*;

public class DetectCycle142 {
    /**
     * leetcode:快慢指针
     * 从相遇点到入环点的距离加上 n-1圈的环长，恰好等于从链表头部到入环点的距离。
     */
    public ListNode detectCycle(ListNode head) {
        ListNode slow = head,fast = head;
        while(fast != null && fast.next != null){
            fast = fast.next.next;
            slow = slow.next;
            if(fast == slow){
                ListNode cur = head;
                while(cur != slow){
                    cur = cur.next;
                    slow = slow.next;
                }
                return cur;
            }
        }
        return null;
    }
    /**
     * leetcode:哈希表
     */
    public ListNode detectCycle1(ListNode head) {
        Set<ListNode> set = new HashSet<>();
        ListNode cur = head;
        while(cur != null){
            if(set.contains(cur)){
                return cur;
            }else {
                set.add(cur);
            }
            cur = cur.next;
        }
        return null;
    }

}
