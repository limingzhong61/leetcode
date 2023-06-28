package lmz.algorithm.other.search_and_recur;


import lmz.algorithm.data_structure.tree.binary_tree.util.TreeNode;

public class IsSubStructure26 {
    /**
     * 思路：dfs
     */
    public boolean isSubStructure(TreeNode A, TreeNode B) {
        if(A == null){
            return false;
        }
        if(A.val == B.val){
            return dfs(A,B);
        }
        return isSubStructure(A.left,B) || isSubStructure(A.right,B);
    }

    private boolean dfs(TreeNode a, TreeNode b) {
        //b == null ,a!= null，a是包含b的
        if(b == null){
            return true;
        }
        if(a == null || a.val != b.val){
            return false;
        }
        return dfs(a.left,b.left) && dfs(a.right,b.right);
    }

    public static void main(String[] args) {
        IsSubStructure26 isSubStructure26 = new IsSubStructure26();
        //isSubStructure26.isSubStructure("[1,2,3]", " [3,1]")
    }
}
