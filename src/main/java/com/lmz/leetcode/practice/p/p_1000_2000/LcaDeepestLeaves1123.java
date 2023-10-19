package com.lmz.leetcode.practice.p.p_1000_2000;

import com.lmz.leetcode.data_structure.binary_tree.po.TreeNode;

import java.util.*;

/**
 * @author: limingzhong
 * @create: 2023-09-06 9:15
 */
public class LcaDeepestLeaves1123 {
    /**
     * dfs 自顶向下
     */
    int maxDepth = 0;
    TreeNode ans = null;

    public TreeNode lcaDeepestLeaves(TreeNode root) {
        if (root == null) return null;
        dfs(root, 0);
        return ans;
    }

    /**
     *
     */
    private int dfs(TreeNode root, int d) {
        // 维护全局最大深度
        if (root == null) {
            maxDepth = Math.max(maxDepth, d);
            return d;
        }
        // 获取左子树最深叶节点的深度
        int leftDepth = dfs(root.left, d + 1);
        // 获取右子树最深叶节点的深度
        int rightDepth = dfs(root.right, d + 1);
        if (leftDepth == rightDepth && leftDepth == maxDepth) {
            ans = root;
        }
        // 当前子树最深叶节点的深度
        return Math.max(leftDepth, rightDepth);
    }
    /**
     * my: bfs找到深度最大一层叶节点，然后逆向找到他们的公共祖先
     *
     * @param root
     * @return
     */
    public TreeNode lcaDeepestLeaves1(TreeNode root) {
        if (root == null) return null;
        TreeNode p = new TreeNode();
        Queue<TreeNode> q = new ArrayDeque<>();
        q.add(root);
        HashMap<TreeNode, TreeNode> map = new HashMap<>();
        Set<TreeNode> set = new HashSet<>();
        while (!q.isEmpty()) {
            int size = q.size();
            HashSet<TreeNode> record = new HashSet<>();
            for (int i = 0; i < size; i++) {
                TreeNode node = q.poll();
                if (node.left != null) {
                    q.add(node.left);
                    map.put(node.left, node);
                    record.add(node.left);
                }
                if (node.right != null) {
                    q.add(node.right);
                    map.put(node.right, node);
                    record.add(node.right);
                }
            }
            if (record.size() != 0) set = record;
        }
        System.out.println(set);
        while (set.size() != 1) {
            Set<TreeNode> nextSet = new HashSet<>();
            for (TreeNode x : set) {
                nextSet.add(map.get(x));
            }
            set = nextSet;
        }
        return set.iterator().next();

    }



}
