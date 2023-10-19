package com.lmz.leetcode.practice.data_structure.tree.binary_tree.bst;

import com.lmz.leetcode.data_structure.binary_tree.po.TreeNode;

import java.util.HashSet;
import java.util.Set;

public class FindTarget653 {
    /**
     * 遍历+hashset（遍历一遍就行了）
     */
    boolean res = false;
    public boolean findTarget(TreeNode root, int k) {
        Set<Integer> set = new HashSet<>();
        return dfs(root,set,k);
    }

    private boolean dfs(TreeNode root,Set<Integer> set,int target) {
        if(root == null){
            return false;
        }
        if(set.contains(target - root.val)){
            return true;
        }
        set.add(root.val);
        return dfs(root.left,set,target) ||dfs(root.right,set,target);
    }
}
