package lmz.algorithm.graph_parse_ds.search_and_recur;

import lmz.algorithm.data_structure.tree.binary_tree.util.TreeNode;

import java.util.LinkedList;
import java.util.Queue;

public class MirrorTree27 {
    /**
     * my:递归(dfs)
     * 给你一棵二叉树的根节点 root ，翻转这棵二叉树，并返回其根节点。
     */
    public TreeNode mirrorTree1(TreeNode root) {
        if(root == null){
            return null;
        }
        root.left = mirrorTree(root.right);
        root.right = mirrorTree(root.left);
        return root;
    }

    /**
     * my:利用辅助队列（栈）(bfs)
     * 给你一棵二叉树的根节点 root ，翻转这棵二叉树，并返回其根节点。
     */
    public TreeNode mirrorTree(TreeNode root) {
        if(root == null){
            return null;
        }
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        while(!queue.isEmpty()){
            TreeNode node = queue.poll();
            TreeNode temp = node.left;
            node.left = node.right;
            node.right = temp;
            if(node.left != null){
                queue.add(node.left);
            }
            if(node.right != null){
                queue.add(node.right);
            }
        }
        return root;
    }
}
