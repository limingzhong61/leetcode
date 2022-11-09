package codeofli.leetcode.other.old.linked_list_tree;

//   Definition for a binary tree node.
class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;

    TreeNode() {
    }

    TreeNode(int val) {
        this.val = val;
    }

    TreeNode(int val, TreeNode left, TreeNode right) {
        this.val = val;
        this.left = left;
        this.right = right;
    }
}

public class SumOfLeftLeaves404 {
    public int sumOfLeftLeaves(TreeNode root) {

       return dfs(root,false);
    }

    private int dfs(TreeNode root, boolean left) {
        if(root == null){
            return 0;
        }
        if(root.left == null && root.right == null){
            if(left){
                return root.val;
            }else {
                return 0;
            }
        }
        return dfs(root.left,true) + dfs(root.right,false);
    }
}
