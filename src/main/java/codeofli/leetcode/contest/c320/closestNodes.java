package codeofli.leetcode.contest.c320;

import codeofli.leetcode.data_structure.tree.binary_tree.TreeNode;

import java.util.ArrayList;
import java.util.List;

public class closestNodes {
    public List<List<Integer>> closestNodes(TreeNode root, List<Integer> queries) {
        List<List<Integer>>  res = new ArrayList<>();
        for(var query :queries){
            int min = findMinE(root,query);
            int max = findMaxE(root,query);
            List<Integer> temp = new ArrayList<>(2);
            temp.add(min);
            temp.add(max);
            res.add(temp);
        }
        return res;
    }

    private int findMinE(TreeNode root, Integer query) {
        int res = -1;
        TreeNode cur = root;
        while (cur != null){
            if(cur.val == query){
                return query;
            }
            if(query > cur.val){
                res  = cur.val;
                cur  = cur.right;
            }else {
                cur = cur.left;
            }
        }
        return res;
    }

    private int findMaxE(TreeNode root, Integer query) {
        int res = -1;
        TreeNode cur = root;
        while (cur != null){
            if(cur.val == query){
                return query;
            }
            if(query < cur.val){
                res  = cur.val;
                cur  = cur.left;
            }else {
                cur = cur.right;
            }
        }
        return res;
    }
}
