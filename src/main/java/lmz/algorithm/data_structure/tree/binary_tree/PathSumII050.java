package lmz.algorithm.data_structure.tree.binary_tree;

import lmz.algorithm.data_structure.tree.binary_tree.util.TreeNode;

import java.util.ArrayList;
import java.util.HashMap;

/**
 * @author: limingzhong
 * @create: 2023-03-17 10:22
 */
public class PathSumII050 {
    /**
     * 前缀和、回溯
     */
    int total = 0;
    public int pathSum(TreeNode root, int targetSum) {
        HashMap<Long,Integer> counter = new HashMap<>();
        counter.put(0L,1);
        search(root,targetSum,counter,0);
        return total;
    }

    private void search(TreeNode root, int targetSum, HashMap<Long, Integer> counter,long sum) {
        if(root == null){
            return;
        }

        sum += root.val;
        total += counter.getOrDefault(sum - targetSum,0);
        //if(root.left == null && root.right == null){
        //
        //    counter.put(sum,counter.getOrDefault(sum,0) - 1);
        //    return;
        //}
        counter.put(sum,counter.getOrDefault(sum,0) + 1);
        search(root.left,targetSum,counter,sum);
        search(root.right,targetSum,counter,sum);
        counter.put(sum,counter.get(sum) - 1);
    }




    /**
     * O(n^2)
     */
    public int pathSum1(TreeNode root, int targetSum) {
        ArrayList<Integer> list = new ArrayList<>();
        search1(root, targetSum, list);
        return total;
    }

    private void search1(TreeNode root, int targetSum, ArrayList<Integer> list) {
        if (root == null) {
            return;
        }
        list.add(root.val);
        int size = list.size(),cnt = 0;
        long sum  = 0;
        // System.out.println(list.toString());
        for (int i = size - 1; i >= 0; i--) {
            sum += list.get(i);
            if(sum == targetSum){
                cnt++;
            }
            //System.out.printf("%d,%d\n", sum, cnt);
        }
        total += cnt;
        // left node compute
        if (root.left == null && root.right == null) {
            list.remove(list.size() - 1);
            return;
        }
        search1(root.left, targetSum, list);
        search1(root.right, targetSum, list);
        list.remove(list.size() - 1);
    }


}
