package lmz.algorithm.data_structure.linked_list.reverse;

import lmz.algorithm.data_structure.linked_list.util.ListNode;
import lmz.my.leetcode.LinkedList;


public class ReverseKGroup25 {
    /**
     * leetcode代码
     */
    public ListNode reverseKGroup(ListNode head, int k) {
        ListNode hair = new ListNode(0);
        hair.next = head;
        ListNode pre = hair;

        while (head != null) {
            ListNode tail = pre;
            // 查看剩余部分长度是否大于等于 k
            for (int i = 0; i < k; ++i) {
                tail = tail.next;
                if (tail == null) {
                    return hair.next;
                }
            }
            ListNode nex = tail.next;
            ListNode[] reverse = myReverse(head, tail);
            head = reverse[0];
            tail = reverse[1];
            // 把子链表重新接回原链表
            pre.next = head;
            tail.next = nex;
            pre = tail;
            head = tail.next;
        }

        return hair.next;
    }
    /**
     * List
     */
    public ListNode reverseKGroup3(ListNode head, int k) {
        ListNode dummy = new ListNode(0, head);
        ListNode cur = dummy;
        ListNode curList = dummy;
        int i = 0;
        ListNode head1 = dummy.next;
        for (; cur != null; ) {
            ListNode next = cur.next;
            if ((i != 0 && i % k == 0 )) {
                cur.next = null; //断链
                ListNode tail = head1; // 逆置后head变为tail
                // System.out.println(head1.val);
                // System.out.println(tail.val);
                // System.out.println("---");
                head1 = reverseList(head1);
                curList.next = head1;
                curList = tail;
                head1 = next; //重置下一段链表的头结点
            }
            i++;
            cur = next;
        }
        curList.next = head1; // 最后一段可能不满足k个的
        return dummy.next;
    }


    /**
     * 迭代逆置链表
     * @param head
     * @return 逆置后的链表头结点
     */
    public ListNode reverseList(ListNode head) {
        ListNode pre = null;
        ListNode cur = head;
        while(cur != null){
            ListNode next = cur.next;
            cur.next = pre;
            pre = cur;
            cur = next;
        }
        return pre;
    }






    public ListNode[] myReverse(ListNode head, ListNode tail) {
        ListNode prev = tail.next;
        ListNode p = head;
        while (prev != tail) {
            ListNode nex = p.next;
            p.next = prev;
            prev = p;
            p = nex;
        }
        return new ListNode[]{tail, head};
    }

    /**
     * List
     */
    public ListNode reverseKGroup1(ListNode head, int k) {
        ListNode dummyHead = new ListNode(); //哑结点
        dummyHead.next = head;
        //1 <= k <= n <= 5000

        ListNode cur = head;
        int len = 0; //统计长度
        while (cur != null) {
            len++;
            cur = cur.next;
        }
        int reverseCnt = len / k;
        ListNode startPre = dummyHead; //需要逆置的k个结点的前一个结点
        ListNode pre = dummyHead;
        cur = head;
        int index = 0;
        for (int i = 0; i < reverseCnt; ) {
            ListNode next = cur.next;
            cur.next = pre;
            if (index % k == k - 1) { // k个结点逆置完
                ListNode start = startPre.next;
                start.next = next; //k个结点的开始结点链接k个结点最后结点的next
                startPre.next = cur;
                startPre = start; //重新记录逆置的k个结点的前一个结点
                pre = startPre; //pre结点变更
                i++;
            } else {
                pre = cur;
            }
            index++;
            //后移一个结点
            cur = next;
        }
        return dummyHead.next;
    }

    public static void main(String[] args) {
        ReverseKGroup25 reverseKGroup25 = new ReverseKGroup25();
        reverseKGroup25.reverseKGroup(LinkedList.StrToLinkedList2("[1,2,3,4,5]"), 2);
    }

}
