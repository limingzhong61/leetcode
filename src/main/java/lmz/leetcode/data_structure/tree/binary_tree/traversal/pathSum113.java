package lmz.leetcode.data_structure.tree.binary_tree.traversal;

import lmz.leetcode.data_structure.tree.binary_tree.normal.TreeNode;
import lmz.my.leetcode.EncodeTree;

import java.util.*;

public class pathSum113 {
    /**
     * leetcode: 用hashMap记录父节点，便于查找路径，节省list记录的空间。
     * 树中节点总数在范围 [0, 5000] 内
     * 我们也可以采用广度优先搜索的方式，遍历这棵树。当我们遍历到叶子节点，且此时路径和恰为目标和时，我们就找到了一条满足条件的路径。
     *
     * 为了节省空间，我们使用哈希表记录树中的每一个节点的父节点。每次找到一个满足条件的节点，我们就从该节点出发不断向父节点迭代，即可还原出从根节点到当前节点的路径。
     */
    public List<List<Integer>> pathSum(TreeNode root, int targetSum) {
        List<List<Integer>> res = new ArrayList<>();
        if (root == null) {
            return res;
        }
        Queue<Pair> pathQueue = new LinkedList<>();
        List<Integer> temp = new ArrayList<>();
        temp.add(root.val);
        Map<TreeNode,TreeNode> parentMap = new HashMap<>();
        pathQueue.add(new Pair(root, root.val));
        while (!pathQueue.isEmpty()) {
            Pair pair = pathQueue.poll();
            TreeNode node = pair.node;
            if (node.left == null && node.right == null && pair.pathSum == targetSum) {
                List<Integer> path = new ArrayList<>();
                while(node != root){
                    path.add(node.val);
                    node = parentMap.get(node);
                }
                path.add(root.val);
                Collections.reverse(path);
                res.add(path);
                continue;
            }
            if (node.left != null) {
                parentMap.put(node.left,node);
                pathQueue.add(new Pair(node.left, pair.pathSum + node.left.val));
            }
            if (node.right != null) {
                parentMap.put(node.right,node);
                pathQueue.add(new Pair(node.right, pair.pathSum + node.right.val));
            }
        }
        return res;
    }

    class Pair {
        int pathSum;
        TreeNode node;

        Pair(TreeNode node, int pathSum) {
            this.node = node;
            this.pathSum = pathSum;
        }
    }
    /**
     * 树中节点总数在范围 [0, 5000] 内
     * BFS:用一个list记录路径
     */
    public List<List<Integer>> pathSum1(TreeNode root, int targetSum) {
        List<List<Integer>> res = new ArrayList<>();
        if (root == null) {
            return res;
        }
        Queue<Three> pathQueue = new LinkedList<>();
        List<Integer> temp = new ArrayList<>();
        temp.add(root.val);
        pathQueue.add(new Three(root, root.val, temp));
        while (!pathQueue.isEmpty()) {
            Three pair = pathQueue.poll();
            TreeNode node = pair.node;
            if (node.left == null && node.right == null && pair.pathSum == targetSum) {
                res.add(pair.paths);
                continue;
            }
            if (node.left != null) {
                temp = new ArrayList<>(pair.paths);
                temp.add(node.left.val);
                pathQueue.add(new Three(node.left, pair.pathSum + node.left.val, temp));
            }
            if (node.right != null) {
                temp = new ArrayList<>(pair.paths);
                temp.add(node.right.val);
                pathQueue.add(new Three(node.right, pair.pathSum + node.right.val, temp));
            }
        }
        return res;
    }

    class Three {
        int pathSum;
        TreeNode node;
        List<Integer> paths;

        Three(TreeNode node, int pathSum, List<Integer> paths) {
            this.node = node;
            this.pathSum = pathSum;
            this.paths = paths;
        }
    }

    public static void main(String[] args) {
        pathSum113 pathSum113 = new pathSum113();
        System.out.println(pathSum113.pathSum(EncodeTree.deserialize("[5,4,8,11,null,13,4,7,2,null,null,5,1]"), 22));
        System.out.println(pathSum113.pathSum(EncodeTree.deserialize("[-2,null,-3]"), -5));
    }
}
