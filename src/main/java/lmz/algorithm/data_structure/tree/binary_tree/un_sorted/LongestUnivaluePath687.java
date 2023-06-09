package lmz.algorithm.data_structure.tree.binary_tree.un_sorted;

import java.util.*;

public class LongestUnivaluePath687 {
    int maxLen = 0;
    public int longestUnivaluePath(TreeNode root) {
        dfs(root,10005);
        return maxLen;
    }

    private int dfs(TreeNode root,int preValue) {
        if(root == null){
            return 0;
        }
        int left = dfs(root.left,root.val);
        int right = dfs(root.right,root.val);
        if(preValue == root.val){
            int total = left+right + 1;
            maxLen = Math.max(maxLen,total);
            return total;
        }
        return 0;
    }



    public static void main(String[] args) {
        Map<Integer,Integer> indexMap = new HashMap<>();
        int i = 0;
        indexMap.put(0,0);
        Integer orDefault = indexMap.getOrDefault(0, i++);
        System.out.println(i);
    }
}
