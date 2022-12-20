package lmz.leetcode.data_structure.linked_list;

public class MergeTwoLists21 {
    /**
     * my:
     * 思路：递归合并
     */
    public ListNode mergeTwoLists(ListNode list1, ListNode list2) {
        if(list1 == null){
            return list2;
        }else if(list2 == null){
            return list1;
        }
        if(list1.val < list2.val){
            list1.next = mergeTwoLists(list1.next,list2);
            return list1;
        }else{
            list2.next = mergeTwoLists(list1,list2.next);
            return list2;
        }
    }

    /**
     * my:
     * 思路：归并
     */
    public ListNode mergeTwoLists1(ListNode list1, ListNode list2) {
        ListNode dummy = new ListNode(0); //哑结点(充当头结点)便于操作
        ListNode cur = dummy;
        while(list1 != null && list2 != null){
            if(list1.val < list2.val){
                cur.next = list1;
                cur = cur.next;
                list1 = list1.next;
            }else {
                cur.next = list2;
                cur = cur.next;
                list2 = list2.next;
            }
        }
        //处理剩余结点
        while (list1 != null){
            cur.next = list1;
            cur = cur.next;
            list1 = list1.next;
        }
        while (list2 != null){
            cur.next = list2;
            cur = cur.next;
            list2 = list2.next;
        }
        //尾结点处理
        cur.next = null;
        return  dummy.next;
    }
}
