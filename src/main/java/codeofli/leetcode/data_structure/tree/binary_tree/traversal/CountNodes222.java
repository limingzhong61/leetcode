package codeofli.leetcode.data_structure.tree.binary_tree.traversal;

import codeofli.leetcode.data_structure.tree.binary_tree.TreeNode;

public class CountNodes222 {
    /**
     * 二分查找 + 位运算
     */
    public int countNodes(TreeNode root) {
        if (root == null) {
            return 0;
        }
        int level = 0;
        TreeNode cur = root;
        while (cur.left != null) {
            level++;
            cur = cur.left;
        }
        int low = 1 << level, high = (1 << (level + 1)) - 1;
        while (low <= high) {
            int mid = low + (high - low) / 2;
            if (exist(root, level, mid)) {
                low = mid + 1;
            } else {
                high = mid - 1;
            }
        }
        return high;
    }

    private boolean exist(TreeNode root, int level, int x) {
        TreeNode cur = root;
        while (cur != null && level >= 0) {
            if( ((1 << level) & x) == 1){
                cur = cur.right;
            }else {
                cur = cur.left;
            }
            level--;
        }
        return cur != null;
    }

    /**
     * 暴力递归
     */
    public int countNodes1(TreeNode root) {
        if (root == null) {
            return 0;
        }
        return countNodes1(root.left) + countNodes1(root.right) + 1;
    }
}
