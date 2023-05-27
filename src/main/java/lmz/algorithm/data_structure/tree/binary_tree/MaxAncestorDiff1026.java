package lmz.algorithm.data_structure.tree.binary_tree;

import lmz.algorithm.data_structure.tree.binary_tree.normal.TreeNode;

/**
 * @author: limingzhong
 * @create: 2023-04-18 13:52
 */
public class MaxAncestorDiff1026 {
    class Solution {
        public int maxAncestorDiff(TreeNode root) {
            return dfs(root, root.val, root.val);
        }

        private int dfs(TreeNode root, int min, int max) {
            if (root == null) {
                return 0;
            }
            int res = Math.max(Math.abs(root.val - min), Math.abs(root.val - max));
            min = Math.min(min, root.val);
            max = Math.max(max, root.val);
            int leftDiff = dfs(root.left, min, max);
            int rightDiff = dfs(root.right, min, max);
            return Math.max(res, Math.max(leftDiff,rightDiff ));
        }
    }
}
