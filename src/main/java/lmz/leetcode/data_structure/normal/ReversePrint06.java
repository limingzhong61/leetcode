package lmz.leetcode.data_structure.normal;


import lmz.leetcode.data_structure.linked_list.ListNode;

import java.util.ArrayList;
import java.util.List;



public class ReversePrint06 {
    /**
     * 递归版
     */
    public int[] reversePrint(ListNode head) {
        List<Integer> nums = new ArrayList<>();
        recur(head, nums);
        int[] ans = new int[nums.size()];
        int index = 0;
        for(int i = nums.size() -1; i >= 0 ;i--){
            ans[index++] = nums.get(i);
        }
        return ans;
    }

    private void recur(ListNode head, List<Integer> nums) {
        if(head == null){
            return ;
        }
        recur(head.next,nums);
        nums.add(head.val);
    }

    public int[] reversePrint1(ListNode head) {
        List<Integer> nums = new ArrayList<>();

        while(head != null){
            nums.add(head.val);
            head = head.next;
        }
        int[] ans = new int[nums.size()];
        int index = 0;
        for(int i = nums.size() -1; i >= 0 ;i--){
            ans[index++] = nums.get(i);
        }
        return ans;
    }

    public static void main(String[] args) {
        ReversePrint06 reversePrint06 = new ReversePrint06();
    }
}
