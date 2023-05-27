package lmz.algorithm.other.old.function;

import java.util.ArrayList;
import java.util.List;
// Definition for a Node.
class Node {
    public int val;
    public List<Node> children;

    public Node() {}

    public Node(int _val) {
        val = _val;
    }

    public Node(int _val, List<Node> _children) {
        val = _val;
        children = _children;
    }
};
public class Preorder589 {
    public List<Integer> preorder(Node root) {
        List<Integer> res = new ArrayList<>();
        preorder(root,res);
        return res;
    }

    private void preorder(Node root, List<Integer> res) {
        if(root == null){
            return;
        }
        res.add(root.val);
        for(Node cur : root.children){
            preorder(cur,res);
        }
    }
}
