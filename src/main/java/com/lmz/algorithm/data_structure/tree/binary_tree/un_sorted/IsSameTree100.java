package com.lmz.algorithm.data_structure.tree.binary_tree.un_sorted;

import com.lmz.leetcode.binary_tree.po.TreeNode;

/**
 * @author: limingzhong
 * @create: 2023-06-07 11:47
 */
public class IsSameTree100 {
    public boolean isSameTree(TreeNode p, TreeNode q) {
        if(p == null || q == null ){
            return p == q;// 只有pq 都空才行
        }
        return p.val == q.val && isSameTree(p.left,q.left) && isSameTree(p.right,q.right);
    }
}
