package codeofli.leetcode.contest.c311;

import codeofli.leetcode.data_structure.tree.binary_tree.TreeNode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public class ReverseOddLevels {
    public TreeNode reverseOddLevels(TreeNode root) {
        if(root == null){
            return null;
        }
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        int levelIdx= 0;
        while(!queue.isEmpty()){
            int size = queue.size();
            if(levelIdx % 2== 0){
                ArrayList<TreeNode> nextList = new ArrayList<>(size * 2);
                for(int i = 0; i < size; i++){
                    TreeNode cur = queue.poll();
                    if(cur.left != null){
                        queue.add(cur.left);
                        nextList.add(cur.left);
                    }
                    if(cur.right != null){
                        queue.add(cur.right);
                        nextList.add(cur.right);
                    }
                }
                ArrayList<Integer> nextVal = new ArrayList<>(size * 2);
                for (TreeNode treeNode : nextList) {
                    nextVal.add(treeNode.val);
                }
                int idx = nextList.size() -1;
                for(int i = 0; i < nextList.size(); i++){
                    nextList.get(i).val = nextVal.get(idx--);
                }
            }else{
                for(int i = 0; i < size; i++){
                    TreeNode cur = queue.poll();
                    if(cur.left != null){
                        queue.add(cur.left);
                    }
                    if(cur.right != null){
                        queue.add(cur.right);
                    }
                }
            }
            levelIdx++;
        }
        return root;
    }
}
