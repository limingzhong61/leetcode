package com.lmz.algorithm_practice.other.old.search_and_recur;

import com.lmz.leetcode.binary_tree.po.TreeNode;

import java.util.ArrayList;
import java.util.List;

public class LowestCommonAncestor68I {
    /**
     * 遍历到两个结点，回退后左右结点都找到一个的最先遇见的结点就是最近公共祖先
     * leetcode: 利用二叉搜索树，左< 中 < 右遍历
     * 一次遍历：获取根结点到p,q结点的路径
     *
     * 我们从根节点开始遍历；
     * 1如果当前节点的值大于 p 和 q 的值，说明 p 和 q 应该在当前节点的左子树，因此将当前节点移动到它的左子节点；
     * 2如果当前节点的值小于 p 和 q 的值，说明 p 和 q 应该在当前节点的右子树，因此将当前节点移动到它的右子节点；
     * 3如果当前节点的值不满足上述两条要求，那么说明当前节点就是「分岔点」。此时，p 和 q 要么在当前节点的不同的子树中，要么其中一个就是当前节点。
     */
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        TreeNode cur = root;
        //p、q 为不同节点且均存在于给定的二叉搜索树中,故不用判断是否为null
        while (cur != null) {
            if (cur.val > p.val && cur.val > q.val) {
                cur = cur.left;
            } else if (cur.val < p.val && cur.val < q.val) {
                cur = cur.right;
            } else {
                return cur;
            }
        }
        return null;
    }

    /**
     * 遍历到两个结点，回退后左右结点都找到一个的最先遇见的结点就是最近公共祖先
     * leetcode: 利用二叉搜索树，左< 中 < 右遍历
     * 两次遍历：获取根结点到p,q结点的路径
     */
    public TreeNode lowestCommonAncestor2(TreeNode root, TreeNode p, TreeNode q) {
        List<TreeNode> pPath = getPath(root, p);
        List<TreeNode> qPath = getPath(root, q);
        TreeNode ans = null;
        for (int i = 0; i < pPath.size() && i < qPath.size(); i++) {
            if (pPath.get(i) != qPath.get(i)) {
                return ans;
            }
            ans = pPath.get(i);
        }
        return ans;
    }

    private List<TreeNode> getPath(TreeNode root, TreeNode target) {
        ArrayList<TreeNode> list = new ArrayList<>();
        TreeNode cur = root;
        //p、q 为不同节点且均存在于给定的二叉搜索树中,故不用判断是否为null
        while (cur != target) {
            list.add(cur);
            if (cur.val > target.val) {
                cur = cur.left;
            } else {
                cur = cur.right;
            }
        }
        list.add(target);
        return list;
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

    public static void main(String[] args) {
        LowestCommonAncestor68I lowestCommonAncestor68I = new LowestCommonAncestor68I();
        //System.out.println(lowestCommonAncestor68I.lowestCommonAncestor(EncodeTree.deserialize("[3,1,4,null,2]"),
        //        new TreeNode(2), new TreeNode(3)).val);
    }

}
