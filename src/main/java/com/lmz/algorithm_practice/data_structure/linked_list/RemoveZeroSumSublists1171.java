package com.lmz.algorithm_practice.data_structure.linked_list;

import com.lmz.algorithm_practice.data_structure.linked_list.util.ListNode;

import java.util.HashMap;
import java.util.Map;

/**
 * @author: limingzhong
 * @create: 2023-06-11 9:41
 */
public class RemoveZeroSumSublists1171 {
    /**
     * hashMap+前缀和
     */
    public ListNode removeZeroSumSublists(ListNode head) {
        ListNode dummy = new ListNode(0);
        dummy.next = head;

        Map<Integer, ListNode> map = new HashMap<>();

        // 首次遍历建立 节点处链表和<->节点 哈希表
        // 若同一和出现多次会覆盖，即记录该sum出现的最后一次节点
        int sum = 0;
        for (ListNode d = dummy; d != null; d = d.next) {
            sum += d.val;
            map.put(sum, d);
        }

        // 第二遍遍历 若当前节点处sum在下一处出现了则表明两结点之间所有节点和为0 直接删除区间所有节点
        sum = 0;
        for (ListNode d = dummy; d != null; d = d.next) {
            sum += d.val;
            d.next = map.get(sum).next;
        }

        return dummy.next;
    }


    /**
     * 循环遍历删除：O(n^2)
     */
    public ListNode removeZeroSumSublists1(ListNode head) {
        ListNode dummy = new ListNode(0,head);


        ListNode p = dummy;
        while(p != null){
            ListNode cur = p.next,start = p;
            int sum = 0;
            boolean deleted = false;
            while(cur != null){
                sum += cur.val;
                if(sum == 0){
                    start.next = cur.next;
                    cur = start.next;
                    deleted = true;
                    break;
                }
                cur = cur.next;
            }
            if(!deleted)
                p = p.next;
        }
        return  dummy.next;
    }
}
