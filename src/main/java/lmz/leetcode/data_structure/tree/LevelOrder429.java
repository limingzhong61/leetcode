package lmz.leetcode.data_structure.tree;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

// Definition for a Node.
class Node {
    public int val;
    public List<Node> children;

    public Node() {
    }

    public Node(int _val) {
        val = _val;
    }

    public Node(int _val, List<Node> _children) {
        val = _val;
        children = _children;
    }
}

//429. N 叉树的层序遍历
public class LevelOrder429 {
    /**
     * bfs
     */
    public List<List<Integer>> levelOrder(Node root) {
        //树的节点总数在 [0, 10^4] 之间
        List<List<Integer>> res = new ArrayList<>();
        if (root == null) {
            return res;
        }
        Queue<Node> queue = new LinkedList<>();
        queue.add(root);
        List<Integer> temp = new ArrayList<>();
        while (!queue.isEmpty()) {
            int size = queue.size();
            temp.clear();
            for (int i = 0; i < size; i++) {
                Node node = queue.poll();
                temp.add(node.val);
                queue.addAll(node.children);
            }
            res.add(new ArrayList<>(temp));
        }
        return res;
    }
}
