package test.old;



/**
 * @author: limingzhong
 * @create: 2023-07-14 14:48
 */
class  ListNode{
    int value;
    ListNode next;
    public  ListNode(int value,ListNode next){
        this.value = value;
        this.next = next;
    }
}
public class ReverseLinkedList {
    ListNode reverse(ListNode root){
        ListNode pre = null,cur = root;
        while(cur != null){
            ListNode next = cur.next;
            cur.next = pre;
            pre = cur;
            cur = next;
        }
        return pre;
    }

    public static void main(String[] args) {
        ListNode dummy = new ListNode(-1,null);
        ListNode cur = dummy;
        int n = 5;
        for(int i = 0; i < n; i++){
            cur.next = new ListNode(i,null);
            cur = cur.next;
        }
        ReverseLinkedList reverseLinkedList = new ReverseLinkedList();
        ListNode root = reverseLinkedList.reverse(dummy.next);

        cur = root;
        while(cur != null){
            System.out.println(cur.value);
            cur = cur.next;
        }

    }
}
