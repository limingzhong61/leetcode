package com.lmz.leetcode.practice.graph.un_sorted;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Queue;

/**
 * @author: limingzhong
 * @create: 2023-06-22 10:51
 */
public class PondSizes {
    /**
     * bfs
     */
    public int[] pondSizes(int[][] land) {
        int m = land.length,n = land[0].length;
        ArrayList<Integer> list = new ArrayList<>();
        for(int i = 0; i < m ;i++){
            for(int j = 0; j < n ;j++){
                if(land[i][j] == 0){
                    // bfs,用-1标记
                    land[i][j] = -1;
                    int size = 0;
                    Queue<int[]> q = new ArrayDeque<>();
                    q.add(new int[]{i,j});
                    int[][] next = new int[][]{{1, 0}, {1, 1}, {0, 1}, {-1, 1}, {-1, 0}, {-1, -1}, {0, -1},{1,-1}};
                    while(!q.isEmpty()){
                        int[] poll = q.poll();
                        int x = poll[0];
                        int y = poll[1];
                        size++;
                        for(int k = 0; k < next.length; k++){
                            int nextX = x +next[k][0];
                            int nextY = y +next[k][1];
                            if(nextX >= 0 && nextX < m && nextY >= 0 && nextY < n
                                    && land[nextX][nextY] == 0){
                                q.add(new int[]{nextX,nextY});
                                land[nextX][nextY] = -1;
                            }
                        }
                    }
                    list.add(size);
                }
            }
        }
        int[] ans = new int[list.size()];
        for(int i = 0; i < list.size(); i++){
            ans[i] = list.get(i);
        }
        Arrays.sort(ans);
        return ans;
    }
}
