package lmz.algorithm.dp;

import java.util.Arrays;
import java.util.List;

/**
 * @author: limingzhong
 * @create: 2023-04-01 14:39
 */
public class MinimumTotalII100 {
    class Solution {
        public int minimumTotal(List<List<Integer>> triangle) {
            /**
             * 1 <= triangle.length <= 20^0
             */
            int n = triangle.size(),m = triangle.get(triangle.size()-1).size();
            int[] f = new int[m];
            final int maxVal = 10000 * 200 + 5;
            Arrays.fill(f,maxVal);
            f[0] = triangle.get(0).get(0);
            for(int i = 0; i < n; i++){
                for(int j = triangle.get(i).size() - 1; j > 0; j--){
                    f[j] = Math.min(f[j],f[j-1]) + triangle.get(i).get(j);
                }
                f[0] += triangle.get(i).get(0);
            }
            int min = 0;
            for(int i = 0; i < m; i++){
                min = Math.min(min,f[i]);
            }
            return min;
        }
    }
}
