package codeofli.leetcode.linkedList;

public class AddTwoNumbers2 {

    /**
     * 迭代添加
     */
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode dummyHead = new ListNode(0,null);
        ListNode cur = dummyHead;
        ListNode cur1 = l1,cur2 = l2;
        int carry = 0;
        while(cur1 != null && cur2 != null){
            // System.out.println("cur1.val:"+cur1.val);
            // System.out.println("cur2.val:"+cur2.val);
            int sum = cur1.val + cur2.val + carry;
            ListNode newNode = new ListNode(sum % 10, null);
            cur.next = newNode;
            cur = newNode;
            // System.out.println("cur.val:"+cur.val);
            carry = sum / 10;
            cur1 = cur1.next;
            cur2 = cur2.next;
        }
        ListNode notNullList = cur1;
        if(notNullList == null){
            notNullList = cur2;
        }
        // carry == 1
        while(carry != 0 && notNullList != null){
            int sum = notNullList.val + carry;
            ListNode newNode = new ListNode(sum %10, null);
            cur.next = newNode;
            cur = newNode;
            notNullList = notNullList.next;
            carry = sum / 10;
        }
        if(carry == 0){
            cur.next = notNullList;
        }else{ // carry == 1
            cur.next = new ListNode(1, null);
        }
        return dummyHead.next;
    }
}
