package codeofli.leetcode.graph_parse_ds.search_and_recur;

import codeofli.leetcode.data_structure.binary_tree.TreeNode;

import java.util.*;

public class PathSum34 {
    /**
     * bfs
     * 为了节省空间，我们使用哈希表记录树中的每一个节点的父节点。
     * 每次找到一个满足条件的节点，我们就从该节点出发不断向父节点迭代，
     * 即可还原出从根节点到当前节点的路径。
     */
    public List<List<Integer>> pathSum(TreeNode root, int target) {
        List<List<Integer>> res = new ArrayList<>();
        if(root == null){
            return res;
        }
        Map<TreeNode,TreeNode> toParent = new HashMap<>();
        Queue<TreeNode> queueNode = new LinkedList<>();
        Queue<Integer> queueSum = new LinkedList<>();
        queueNode.add(root);
        queueSum.add(root.val);
        while(!queueNode.isEmpty()){
            TreeNode node = queueNode.poll();
            int sum = queueSum.poll();
            if(node.left == null && node.right ==null ){
                if(sum == target){
                    res.add(getPath(node,toParent));
                }
            }else{
                if(node.left != null){
                    queueNode.add(node.left);
                    queueSum.add(sum+ node.left.val);
                    toParent.put(node.left, node);
                }
                if(node.right != null){
                    queueNode.add(node.right);
                    queueSum.add(sum+ node.right.val);
                    toParent.put(node.right, node);
                }
            }
        }
        return res;
    }

    private ArrayList<Integer> getPath(TreeNode node, Map<TreeNode, TreeNode> toParent) {
        ArrayList<Integer> record = new ArrayList<>();
        while(node != null){
            record.add(node.val);
            node = toParent.get(node);
        }
        Collections.reverse(record);
        return record;
    }

    /**
     * dfs search
     */
    List<List<Integer>> res = new ArrayList<>();

    public List<List<Integer>> pathSum1(TreeNode root, int target) {
        search(0, new ArrayList<>(), root, target);
        return res;
    }

    private void search(int sum, List<Integer> record, TreeNode root, int target) {
        if (root == null) {
            return;
        }
        record.add(root.val);
        sum += root.val;
        if(root.left == null && root.right == null && sum == target){
            res.add(new ArrayList<>(record));
            record.remove(record.size() - 1);
            return;
        }
        search(sum, record, root.left, target);
        search(sum, record, root.right, target);
        record.remove(record.size() - 1);
    }
}
