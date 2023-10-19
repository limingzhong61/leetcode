package com.lmz.leetcode.practice.data_structure.tree.binary_tree.un_sorted;

import com.lmz.leetcode.data_structure.binary_tree.po.TreeNode;

public class InsertIntoMaxTree998 {
    /**
     * 题目的意思是本来构造最大数的数组是A，在A中找出最大的值当做根，最大值左边的值为左子树，右边的数组为右子树。
     *
     * 而现在向A的后面插入了val，如果val是最大的，那么根节点的值就要是val，val前面的数（也就是前面的整棵树）
     * 做为val的左子树。如果val不是最大的，那么就把val往右子树上面插（val的位置是最后，肯定在最大值右边）。
     *
     * 所以也就是向最大树root中添加一值为val的节点，如果val大于root的值，那么就把root当做值为val节点左孩子，
     * 否则，就把val插入到右孩子的相应位置。
     */
    public TreeNode insertIntoMaxTree(TreeNode root, int val) {
        if(root == null){
            return new TreeNode(val);
        }
        if(root.val < val){
            TreeNode node = new TreeNode(val);
            node.left = root;
            return node;
        }
        root.right = insertIntoMaxTree(root.right,val);
        return root;
    }
}
