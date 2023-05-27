package lmz.algorithm.data_structure.linked_list;


public class AddTwoNumbers2 {
    /**
     * 迭代添加：优化
     */
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode dummyHead = new ListNode(0, null);
        ListNode cur = dummyHead;
        ListNode cur1 = l1, cur2 = l2;
        int carry = 0;
        while (cur1 != null || cur2 != null || carry != 0) {
            int x = cur1 == null ? 0 : cur1.val;
            int y = cur2 == null ? 0 : cur2.val;
            int sum = x + y + carry;
            ListNode newNode = new ListNode(sum % 10, null);
            cur.next = newNode;
            cur = newNode;
            carry = sum / 10;
            if (cur1 != null) {
                cur1 = cur1.next;
            }
            if (cur2 != null) {
                cur2 = cur2.next;
            }
        }
        return dummyHead.next;
    }


}
