package com.lmz.leetcode.practice.find;

import com.lmz.leetcode.practice.data_structure.linked_list.util.ListNode;
import com.lmz.leetcode.data_structure.binary_tree.po.TreeNode;

public class IsSubPath1367 {
    /**
     * dfs：遍历所有树结点，然后再在此结点上进行比较
     二叉树n个，链表m个
     O(m*n)
     */
    public boolean isSubPath(ListNode head, TreeNode root) {
        if (root == null) {
            return false;
        }
        if(check(root, head)){
            return true;
        }
        return isSubPath(head, root.left) || isSubPath(head, root.right);
    }


    boolean check(TreeNode root, ListNode head) {
        if (head == null) {
            return true;
        }
        if (root == null) {
            return false;
        }
        if (root.val != head.val) {
            return false;
        }
        return check(root.left, head.next) || check(root.right, head.next);
    }
}
