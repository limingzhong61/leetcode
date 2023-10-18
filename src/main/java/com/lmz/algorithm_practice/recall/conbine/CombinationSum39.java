package com.lmz.algorithm_practice.recall.conbine;

import java.util.ArrayList;
import java.util.List;

public class CombinationSum39 {
    /**
     * 回溯
     */
    List<List<Integer>> ans  = new ArrayList<>();
    List<Integer> path  = new ArrayList<>();
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        dfs(candidates,target,0);
        return  ans;
    }

    private void dfs(int[] candidates, int target, int sum) {
        if(sum > target){
            return;
        }
        if(sum == target){
            ans.add(new ArrayList<>(path));
            return;
        }
        for(int i = 0; i < candidates.length; i++){
            // System.out.println(path.toString());
            // 规定 path 后一个 >= 前一个
            if(path.size() > 0 && path.get(path.size() - 1) > candidates[i]) continue;

            sum += candidates[i];
            path.add(candidates[i]);
            dfs(candidates,target,sum);
            path.remove(path.size()-1);
            sum -= candidates[i]; // 恢复现场
        }
    }

}
