package codeofli.leetcode.point_to_offer.search_and_recur;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class LevelOrder31I {
    /**
     * 层次遍历
     */
    public int[] levelOrder(TreeNode root) {
        if(root == null){
            return new int[0];
        }
        Queue<TreeNode> queue = new LinkedList<>();
        List<Integer> list = new ArrayList<>();
        queue.add(root);
        while(!queue.isEmpty()){
            TreeNode cur = queue.poll();
            list.add(cur.val);
            if(cur.left != null){
                queue.add(cur.left);
            }
            if(cur.right != null){
                queue.add(cur.right);
            }
        }
        int[] results = new int[list.size()];
        int index = 0;
        for(int item : list){
            results[index++] = item;
        }
        return results;
    }
}
