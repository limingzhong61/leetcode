package com.lmz.algorithm_practice.data_structure.linked_list.find;

import com.lmz.algorithm_practice.data_structure.linked_list.util.ListNode;

import java.util.HashSet;
import java.util.Set;

/**
 * @author: limingzhong
 * @create: 2023-01-24 14:55
 */
public class DetectCycleII022 {
    /**
     * O(1)空间，双指针
     * 1. **走a+nb步一定是在环入口**
     * 2. **第一次相遇时慢指针已经走了nb步**
     */
    public ListNode detectCycle(ListNode head) {
        ListNode fast = head, slow = head.next;
        while (true) {
            if (fast == null || fast.next == null) return null; // 不存在环
            fast = fast.next.next;
            slow = slow.next;
            if (fast == slow) break;
        }
        fast = head;
        while(fast != slow){
            fast = fast.next;
            slow = slow.next;
        }
        return fast;
    }
    /**
     * 使用hash记录
     */
    public ListNode detectCycle1(ListNode head) {
        ListNode pos = head;
        Set<ListNode> visited = new HashSet<ListNode>();
        while (pos != null) {
            if (visited.contains(pos)) {
                return pos;
            } else {
                visited.add(pos);
            }
            pos = pos.next;
        }
        return null;
    }
}
