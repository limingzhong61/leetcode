package com.lmz.leetcode.practice.other.old.search_and_recur;

import com.lmz.leetcode.data_structure.binary_tree.po.TreeNode;

public class LowestCommonAncestor68II {
    /**
     * 代码优化：
     * 递归遍历
     */
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if(root == null) return null; // 如果树为空，直接返回null
        if(root == p || root == q) return root; // 如果 p和q中有等于 root的，那么它们的最近公共祖先即为root（一个节点也可以是它自己的祖先）
        //因为先遍历到了p，而后面没有遍历q,则p就是q的祖先
        TreeNode left = lowestCommonAncestor(root.left, p, q); // 递归遍历左子树，只要在左子树中找到了p或q，则先找到谁就返回谁
        TreeNode right = lowestCommonAncestor(root.right, p, q); // 递归遍历右子树，只要在右子树中找到了p或q，则先找到谁就返回谁
        if(left == null) return right; // 如果在左子树中 p和 q都找不到，则 p和 q一定都在右子树中，右子树中先遍历到的那个就是最近公共祖先（一个节点也可以是它自己的祖先）
        else if(right == null) return left; // 否则，如果 left不为空，在左子树中有找到节点（p或q），这时候要再判断一下右子树中的情况，如果在右子树中，p和q都找不到，则 p和q一定都在左子树中，左子树中先遍历到的那个就是最近公共祖先（一个节点也可以是它自己的祖先）
        else return root; //否则，当 left和 right均不为空时，说明 p、q节点分别在 root异侧, 最近公共祖先即为 root
    }
    /**
     * 遍历到两个结点，回退后左右结点都找到一个的最先遇见的结点就是最近公共祖先
     * 递归遍历
     */
    TreeNode res = null;

    public TreeNode lowestCommonAncestor1(TreeNode root, TreeNode p, TreeNode q) {
        recur(root, p, q);
        return res;
    }

    private boolean recur(TreeNode root, TreeNode p, TreeNode q) {
        if (root == null) {
            return false;
        }
        boolean leftFind = recur(root.left, p, q);
        boolean rightFind = recur(root.right, p, q);
        if (leftFind && rightFind) {
            res = root;
            return true;
        }
        if (root.val == p.val || root.val == q.val) {
            //已经找到一个，且当前结点为要找的结点
            if (leftFind || rightFind) {
                res = root;
            }
            return true;
        }

        return leftFind || rightFind;
    }
}
