package lmz.leetcode.other.medium;

import lmz.leetcode.data_structure.tree.binary_tree.normal.TreeNode;

/**
 * @author: limingzhong
 * @create: 2023-05-22 10:45
 */
public class SufficientSubset1080 {
    class Solution {
        public TreeNode sufficientSubset(TreeNode root, int limit) {
            return dfs(root, limit, 0);
        }

        private TreeNode dfs(TreeNode node, int limit, int sum) {
            if (node == null) return null;
            sum += node.val;
            boolean isLeaf = false;
            if(node.left == null && node.right == null){// 不是叶子节点，sum < limit 删除
                if (sum < limit) {
                    return null;
                }
                isLeaf = true;
            }
            node.left = dfs(node.left, limit, sum);
            node.right = dfs(node.right, limit, sum);
            if(!isLeaf && node.left == null && node.right == null){ // 不是叶子节点，但是左右子节点都被删除了
                return  null;
            }
            return node;
        }
    }
}
