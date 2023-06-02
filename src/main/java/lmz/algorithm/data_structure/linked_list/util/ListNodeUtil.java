package lmz.algorithm.data_structure.linked_list.util;

/**
 * 链表工具类
 * @author: limingzhong
 * @create: 2023-06-02 15:09
 */
public class ListNodeUtil {

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
}
