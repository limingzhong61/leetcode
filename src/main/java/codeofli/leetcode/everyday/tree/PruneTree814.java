package codeofli.leetcode.everyday.tree;

import codeofli.leetcode.data_structure.binary_tree.TreeNode;

public class PruneTree814 {
    /**
     * 递归
     */
    public TreeNode pruneTree(TreeNode root) {
        if (root == null) {
            return null;
        }
        root.left = pruneTree(root.left);
        root.right = pruneTree(root.right);
        if (root.left == null && root.right == null && root.val == 0) { //叶子结点
            return null;
        }
        return root;
    }
}
