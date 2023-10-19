package com.lmz.leetcode.practice.data_structure.tree.binary_tree.find;


import com.lmz.leetcode.data_structure.binary_tree.po.TreeNode;

import java.util.HashMap;
import java.util.HashSet;

public class LowestCommonAncestor236 {
    /**
     *
     * 因为所有 Node.val 互不相同 。
     */
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if (root == null || root == p || root == q) {
            //只要当前根节点是p和q中的任意一个，就返回（因为不能比这个更深了，再深p和q中的一个就没了）
            return root;
        }
        //根节点不是p和q中的任意一个，那么就继续分别往左子树和右子树找p和q
        TreeNode left = lowestCommonAncestor(root.left, p, q);
        TreeNode right = lowestCommonAncestor(root.right, p, q);
        //p和q都没找到，那就没有
        if(left == null && right == null) {
            return null;
        }
        //左子树没有p也没有q，就返回右子树的结果
        if (left == null) {
            return right;
        }
        //右子树没有p也没有q就返回左子树的结果
        if (right == null) {
            return left;
        }
        //左右子树都找到p和q了，那就说明p和q分别在左右两个子树上，所以此时的最近公共祖先就是root
        return root;
    }


    TreeNode result = null;
    public TreeNode lowestCommonAncestor2(TreeNode root, TreeNode p, TreeNode q) {
        f(root,p,q);
        return result;
    }

    private TreeNode f(TreeNode root, TreeNode p, TreeNode q) {
        if(root == null) return null;
        if(root == p || root== q){

            return root;
        }
        //根节点不是p和q中的任意一个，那么就继续分别往左子树和右子树找p和q
        TreeNode left = f(root.left, p, q);
        TreeNode right = f(root.right, p, q);
        //p和q都没找到，那就没有
        if(left != null && right != null ){
            result = root;
            return root;
        }
        if(left != null) return left;
        if(right != null) return right;
        return null;
    }



    /**
     * 后序遍历，当找到两个结点时为最近公共祖先·
     * p、q不是同一指针
     */
    public TreeNode lowestCommonAncestor1(TreeNode root, TreeNode p, TreeNode q) {
        find(root, p, q);
        return result;
    }

    public boolean find(TreeNode root, TreeNode p, TreeNode q) {
        
        if (root == null) {
            return false;
        }
        boolean left = find(root.left, p, q);
        boolean right = find(root.right, p, q);
        if (left && right) { //2
            result = root;
            return true;
        }
        if (root == p || root == q) { // 1
            if (left || right) { //1+1 = 2
                result = root;
            }
            return true;
        }
        return left || right;  //只可能有1，有二已经有结果了
    }


    HashMap<Integer, TreeNode> parent = new HashMap<>();
    HashSet<TreeNode> set = new HashSet<>();
    private void dfs(TreeNode root){
        if(root.left != null){
            parent.put(root.left.val,root);
            dfs(root.left);
        }
        if(root.right != null){
            parent.put(root.right.val,root);
            dfs(root.right);
        }
    }

    /**
     * 法二：记录父节点
     */
    public TreeNode lowestCommonAncestor5(TreeNode root, TreeNode p, TreeNode q) {
        if(root == null) {
            return null;
        }
        parent.put(root.val,null);
        dfs(root);
        //TreeNode cur = p;
        while(p != null){
            set.add(p);
            p = parent.get(p.val);
        }
        while(q != null){
            if(set.contains(q)){
                return q;
            }
            set.add(q);
            q= parent.get(q.val);
        }
        return null;
    }

}
