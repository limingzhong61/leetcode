package codeofli.leetcode.graph_theory;

public class NumOfMinutes1376 {
    /**
     *dfs + 记忆化搜索
     */
    int[] allTime;
    public int numOfMinutes(int n, int headID, int[] manager, int[] informTime) {
        int maxTime = 0;
        allTime = new int[n];
        for(int i = 0; i < n; i++){
            maxTime = Math.max(dfs(i,manager,informTime ),maxTime);
        }
        return maxTime;
    }

    private int dfs(int i, int[] manager, int[] informTime) {
        // 员工得到消息的时间已经知道则直接返回即可
        if(manager[i] == -1 || allTime[i] != 0){
            return allTime[i];
        }
        return allTime[i] = informTime[manager[i]] + dfs(manager[i],manager,informTime);
    }

}
