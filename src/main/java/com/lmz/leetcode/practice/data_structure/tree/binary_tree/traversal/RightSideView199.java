package com.lmz.leetcode.practice.data_structure.tree.binary_tree.traversal;

import com.lmz.leetcode.data_structure.binary_tree.po.TreeNode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class RightSideView199 {
    /**
     * DFS:我们对树进行深度优先搜索，在搜索过程中，我们总是先访问右子树。
     * 那么对于每一层来说，我们在这层见到的第一个结点一定是最右边的结点。
     * 我们按照 「根结点 -> 右子树 -> 左子树」 的顺序访问， 就可以保证每层都是最先访问最右边的节点的。
     * （与先序遍历 「根结点 -> 左子树 -> 右子树」 正好相反，先序遍历每层最先访问的是最左边的节点）
     */
    List<Integer> rightNodes = new ArrayList<>();
    public List<Integer> rightSideView(TreeNode root) {
        dfs(root,0); // 从根节点开始访问，根节点深度是0
        return rightNodes;
    }

    private void dfs(TreeNode root, int depth) {
        if(root == null){
            return;
        }
        // 先访问 当前节点，再递归地访问 右子树 和 左子树。
        if (depth == rightNodes.size()) {   // 如果当前节点所在深度还没有出现在res里，说明在该深度下当前节点是第一个被访问的节点，因此将当前节点加入res中。
            rightNodes.add(root.val);
        }
        dfs(root.right,depth+1);
        dfs(root.left,depth+1);
    }


    /**
     * BFS:层次遍历，每一层最后一个结点为右边结点能看见的
     */
    public List<Integer> rightSideView1(TreeNode root) {
        List<Integer> rightNodes = new ArrayList<>();
        if(root == null){
            return rightNodes;
        }
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        while (!queue.isEmpty()) {
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                TreeNode node = queue.poll();
                if (i == size - 1) {
                    rightNodes.add(node.val);
                }
                if (node.left != null) {
                    queue.add(node.left);
                }
                if (node.right != null) {
                    queue.add(node.right);
                }
            }
        }
        return rightNodes;
    }

}
