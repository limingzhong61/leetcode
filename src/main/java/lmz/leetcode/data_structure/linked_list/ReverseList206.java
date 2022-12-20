package lmz.leetcode.data_structure.linked_list;

public class ReverseList206 {
    /**
     * my:递归逆置
     */
    public ListNode reverseList1(ListNode head) {
        //逆置后，head.next = null;
        return reverse(head,null);
    }
    public ListNode reverse(ListNode head, ListNode preNode){
        if(head == null){ //preNode 为尾结点
            return preNode;
        }
        ListNode root = reverse(head.next,head);
        head.next = preNode;
        return root;
    }

    /**
     * my:迭代逆置
     */
    public ListNode reverseList(ListNode head) {
        ListNode preNode = null;
        while (head != null){
            ListNode temp = head.next;
            head.next = preNode;
            preNode = head;
            head = temp;
        }
        return preNode; //preNode为尾结点

    }
}
