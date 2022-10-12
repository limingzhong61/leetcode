package codeofli.leetcode.other.easy;

import codeofli.leetcode.data_structure.linked_list.ListNode;

import java.util.Arrays;
import java.util.Collections;
import java.util.HashSet;
import java.util.Set;
import java.util.stream.IntStream;

public class NumComponents817 {
    /**
     * set查找
     * Node.val 中所有值 不同,nums 中所有值 不同
     */
    public int numComponents(ListNode head, int[] nums) {
        Set<Integer> set = new HashSet<>();
        for(int num : nums){
            set.add(num);
        }
        ListNode cur = head;
        int cnt = 0;
        while(cur != null){
            if(set.contains(cur.val)){
                cnt++;
                while (cur != null && set.contains(cur.val)) {
                    set.remove(cur.val);
                    cur = cur.next;
                }
            }else{
                cur = cur.next;
            }
        }
        return cnt;
    }
}
