package codeofli.leetcode.data_structure.binary_tree.summary;

import codeofli.leetcode.data_structure.binary_tree.binary_tree.TreeNode;

import java.util.HashMap;
import java.util.HashSet;

public class LowestCommonAncestor {
    TreeNode result = null;

    /**
     * p、q不是同一指针
     *
     * @param root
     * @param p
     * @param q
     * @return
     */
    public TreeNode lowestCommonAncestor1(TreeNode root, TreeNode p, TreeNode q) {
        find(root, p, q);
        return result;
    }

    public boolean find(TreeNode root, TreeNode p, TreeNode q) {
        
        if (root == null) {
            return false;
        }
        boolean left = find(root.left, p, q);
        boolean right = find(root.right, p, q);
        if (root == p || root == q) { // 1
            // if(root.val == 5){
            //     // System.out.println("val:5" + left + right );
            // }
            
            if (left || right) { //1+1 = 2
                result = root;
            }
            return true;
        } else if (left && right) { //2
            
            result = root;
            return true;
        }
        return left || right;  //只可能有1，有二已经有结果了
    }


    HashMap<Integer, TreeNode> parent = new HashMap<>();
    HashSet<TreeNode> set = new HashSet<>();
    private void dfs(TreeNode root){
        if(root.left != null){
            parent.put(root.left.val,root);
            dfs(root.left);
        }
        if(root.right != null){
            parent.put(root.right.val,root);
            dfs(root.right);
        }
    }

    /**
     * 法二：记录父节点
     * @param root
     * @param p
     * @param q
     * @return
     */
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if(root == null) {
            return null;
        }
        parent.put(root.val,null);
        dfs(root);
        //TreeNode cur = p;
        while(p != null){
            set.add(p);
            p = parent.get(p.val);
        }
        while(q != null){
            if(set.contains(q)){
                return q;
            }
            set.add(q);
            q= parent.get(q.val);
        }
        return null;
    }

}
