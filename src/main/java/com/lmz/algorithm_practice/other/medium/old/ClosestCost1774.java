package com.lmz.algorithm_practice.other.medium.old;

public class ClosestCost1774 {

    /**
     * 每种类型的配料 最多两份 。
     * f回溯
     */
    public int closestCost(int[] baseCosts, int[] toppingCosts, int target) {
        for (var base : baseCosts) {
            f(target, toppingCosts, 0,base);
        }
        System.out.println(minDiff);
        return res;
    }
    int res = -1;
    int minDiff = Integer.MAX_VALUE;
    private void f(int target, int[] toppingCosts, int cur, int curCost) {
        if(curCost >= target){ // 后面之后越来越大
            if(curCost - target < minDiff){
                minDiff = curCost - target;
                res = curCost;
            }
            return;
        }
        if(target - curCost <= minDiff){
            minDiff = curCost - target;
            res = curCost;
        }
        if(cur == toppingCosts.length){
            return;
        }
        f(target,toppingCosts,cur + 1,curCost); // 0
        f(target,toppingCosts,cur + 1,curCost + toppingCosts[cur] ); // 1
        f(target,toppingCosts,cur + 1,curCost+ toppingCosts[cur] * 2); // 2
    }
}
