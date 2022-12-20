package lmz.leetcode.data_structure.linked_list;

import java.util.*;

public class HasCycle141 {
    /**
     * my:双指针
     * fast:2步，slow：1步，如果追上则有环。
     * 时间：~O(n),空间O(1)
     */
    public boolean hasCycle(ListNode head) {
       ListNode fast = head;
       ListNode slow = head;
       while (fast != null && fast.next != null){
           fast = fast.next.next;
           slow = slow.next;
           if(fast == slow){
               return true;
           }
       }
        return false;
    }

    /**
     * my:遍历+hashSet
     * 时间：O(1),空间O(n)
     */
    public boolean hasCycle1(ListNode head) {
        Set<ListNode> set = new HashSet<>();
        for(ListNode cur = head; cur != null; cur = cur.next){
            if(set.contains(cur)){
                return  true;
            }
            set.add(cur);
        }
        return false;
    }


}
