package exam.old.xingxingchongdian.t2;

import java.util.*;

class TreeNode {
    int val = 0;
    TreeNode left = null;
    TreeNode right = null;

    public TreeNode(int val) {
        this.val = val;
    }
}

public class Solution {
    /**
     * 代码中的类名、方法名、参数名已经指定，请勿修改，直接返回方法规定的值即可
     *
     * @param root TreeNode类
     * @param target int整型
     * @param k int整型
     * @return int整型一维数组
     */


    public ArrayList<Integer> distanceKnodes(TreeNode root, int target, int k) {
        ArrayList<ArrayList<Integer>> adj = new ArrayList<>();
        // write code here
        int n = 11001;
        for(int i = 0; i < n; i++){
            adj.add(new ArrayList<>());
        }
        dfs(root,adj);
        boolean[] visited = new boolean[n];
        Queue<Integer> q = new ArrayDeque<>();
        q.add(target);
        visited[target] = true;
        while(!q.isEmpty()  && k > 0){
            int size = q.size();
            for(int i = 0; i < size; i++){
                int u = q.poll();
                for(int v : adj.get(u)){
                    if(!visited[v]){
                        visited[v] = true;
                        q.add(v);
                    }
                }
            }
            k--;
        }
        System.out.println(q);
        ArrayList<Integer> ans = new ArrayList<Integer>();
        int idx = 0;
        while(!q.isEmpty()){
            ans.add(q.poll());
        }
        return ans;
    }


    private void dfs(TreeNode root,ArrayList<ArrayList<Integer>> adj) {
        if (root == null) return;
        if (root.left != null) {
            adj.get(root.val).add(root.left.val);
            adj.get(root.left.val).add(root.val);
        }
        if (root.right != null) {
            adj.get(root.val).add(root.right.val);
            adj.get(root.right.val).add(root.val);
        }
    }

    public static void main(String[] args) {

    }
}