package lmz.algorithm.find;

import lmz.algorithm.data_structure.tree.binary_tree.normal.TreeNode;
import lmz.algorithm.data_structure.linked_list.ListNode;

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
