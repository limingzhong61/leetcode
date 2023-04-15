package lmz.leetcode.other.medium;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;

/**
 * @author: limingzhong
 * @create: 2023-04-15 14:51
 */
public class GardenNoAdj1042 {
    public int[] gardenNoAdj(int n, int[][] paths) {
        ArrayList<Integer>[] g = new ArrayList[n];
        Arrays.setAll(g,e -> new ArrayList<>());
        for(int[] path : paths){
            int x = path[0] - 1;
            int y = path[1] - 1;
            g[x].add(y);
            g[y].add(x);
        }

        int[] ans = new int[n];
        for (int i = 0; i < n; i++) {
            boolean[] colored = new boolean[5];
            for (int vertex : g[i]) {
                colored[ans[vertex]] = true;
            }
            for (int j = 1; j <= 4; j++) {
                if (!colored[j]) {
                    ans[i] = j;
                    break;
                }
            }
        }
        return ans;
    }
}
