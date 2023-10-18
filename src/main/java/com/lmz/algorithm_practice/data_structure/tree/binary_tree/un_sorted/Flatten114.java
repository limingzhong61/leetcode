package com.lmz.algorithm_practice.data_structure.tree.binary_tree.un_sorted;

import com.lmz.leetcode.binary_tree.po.TreeNode;

import java.util.ArrayList;
import java.util.List;

/**
 * @author: limingzhong
 * @create: 2023-06-09 11:29
 */
public class Flatten114 {
    /**
     * 先序遍历
     *
     * @param root
     */
    public void flatten(TreeNode root) {
        List<TreeNode> list = preOrderList(root);
        TreeNode dummy = new TreeNode();
        TreeNode cur = dummy;
        for(var x : list){
            cur.right = x;
            cur.left = null;
            cur = cur.right;
        }
    }

    /**
     * 返回前序遍历的结果list
     *
     * @param root
     * @return
     */
    public static List<TreeNode> preOrderList(TreeNode root) {
        ArrayList<TreeNode> list = new ArrayList<>();
        preOrder(root, list);
        return list;
    }

    private static void preOrder(TreeNode root, ArrayList<TreeNode> list) {
        if (root == null) return;
        list.add(root);
        preOrder(root.left, list);
        preOrder(root.right, list);
    }
}
