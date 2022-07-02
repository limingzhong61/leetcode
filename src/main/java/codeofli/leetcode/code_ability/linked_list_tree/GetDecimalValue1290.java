package codeofli.leetcode.code_ability.linked_list_tree;

// Definition for singly-linked list.
class ListNode {
    int val;
    ListNode next;

    ListNode() {
    }

    ListNode(int val) {
        this.val = val;
    }

    ListNode(int val, ListNode next) {
        this.val = val;
        this.next = next;
    }
}

public class GetDecimalValue1290 {
    public int getDecimalValue(ListNode head) {
        int res = 0;
        while(head != null){
            res = (res << 1) + head.val;
            head = head.next;
        }
        return  res;
    }

    public static void main(String[] args) {
        GetDecimalValue1290 getDecimalValue1290 = new GetDecimalValue1290();
        getDecimalValue1290.getDecimalValue(null);
    }
}
