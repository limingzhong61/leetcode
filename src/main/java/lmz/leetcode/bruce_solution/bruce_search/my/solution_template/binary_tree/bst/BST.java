package lmz.leetcode.bruce_solution.bruce_search.my.solution_template.binary_tree.bst;

import lmz.leetcode.data_structure.tree.binary_tree.normal.TreeNode;

public class BST {
    /**
     * 在二叉搜索树中插入一个结点 node
     * 注：在该二叉搜索树中不存在值相等的结点
     *
     * @param root
     * @param node
     * @return
     */
    private TreeNode insertBST(TreeNode root, TreeNode node) {
        if (root == null) {
            return node;
        }
        TreeNode cur = root;
        // 插入结点
        TreeNode pre = root;
        while (cur != null) {
            if (cur.val < node.val) {
                pre = cur;
                cur = cur.right;
            } else { // >
                pre = cur;
                cur = cur.left;
            }
        }
        if (node.val < pre.val) {
            pre.left = node;
        } else {
            pre.right = node;
        }
        return root;
    }
}
