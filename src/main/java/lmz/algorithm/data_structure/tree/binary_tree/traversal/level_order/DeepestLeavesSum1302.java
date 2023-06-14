package lmz.algorithm.data_structure.tree.binary_tree.traversal.level_order;

import lmz.algorithm.data_structure.tree.binary_tree.util.TreeNode;

import java.util.LinkedList;
import java.util.Queue;

public class DeepestLeavesSum1302 {
    /**
     * bfs-层次遍历
     * 树中节点数目在范围 [1, 104] 之间
     */
    public int deepestLeavesSum(TreeNode root) {
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        int lastSum = 0;
        while (!queue.isEmpty()) {
            int size = queue.size();
            lastSum += size;
            for (int i = 0; i < size; i++) {
                TreeNode node = queue.poll();
                if(node.left != null){
                    queue.add(node.left);
                }
                if(node.right != null){
                    queue.add(node.right);
                }
            }
        }
        return lastSum;
    }


}
