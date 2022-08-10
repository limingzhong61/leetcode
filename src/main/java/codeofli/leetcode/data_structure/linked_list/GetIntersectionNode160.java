package codeofli.leetcode.data_structure.linked_list;


import java.util.HashSet;
import java.util.Set;

public class GetIntersectionNode160 {
    /**
     * leetcode:双指针法
     * 两个链表长度设分别为m+n:
     * 两个指针共同遍历m+n,
     */
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        if (headA == null || headB == null) {
            return null;
        }
        ListNode pA = headA, pB = headB;
        while (pA != pB) {
            pA = pA == null ? headB : pA.next;
            pB = pB == null ? headA : pB.next;
        }
        return pA;
    }

    /**
     * leetcode:hash表
     */
    public ListNode getIntersectionNode2(ListNode headA, ListNode headB) {
        Set<ListNode> set = new HashSet<>();
        while(headA != null){
            set.add(headA);
            headA = headA.next;
        }
        while(headB != null){
            if(set.contains(headB)){
                return headB;
            }
            headB = headB.next;
        }
        return null;
    }

    /**
     * 分别获取headA和B的长度m，n
     * sub = m -n ,长指针的先移动sub长度，然后两个一起移动，两者相等则为相交结点
     */
    public ListNode getIntersectionNode1(ListNode headA, ListNode headB) {
        int lengthA = getLinkedListLength(headA);
        int lengthB = getLinkedListLength(headB);
        ListNode maxList,minList;
        int subLength = 0;
        if(lengthA > lengthB){
            subLength = lengthA - lengthB;
            maxList = headA;
            minList = headB;
        }else{
            subLength = lengthB - lengthA;
            maxList = headB;
            minList = headA;
        }
        System.out.println(subLength);
        while(subLength != 0){
            maxList = minList.next;
            subLength--;
        }
        //现在maxList和minList指针后面的结点长度是一样的
        while (maxList != null){
            if(maxList == minList){
                return minList;
            }
            maxList = maxList.next;
            minList = minList.next;
        }
        return null;
    }
    private int getLinkedListLength(ListNode head){
        ListNode cur = head;
        int length = 0;
        while(cur != null){
            length++;
            cur = cur.next;
        }
        return length;
    }


    public static void main(String[] args) {

    }
}
