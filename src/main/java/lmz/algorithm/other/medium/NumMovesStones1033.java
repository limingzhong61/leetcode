package lmz.algorithm.other.medium;

import java.util.Arrays;

/**
 * @author: limingzhong
 * @create: 2023-04-30 10:27
 */
public class NumMovesStones1033 {
    class Solution {
        public int[] numMovesStones(int a, int b, int c) {
            int[] loc = {a, b, c};
            Arrays.sort(loc);
            int max = loc[2] - loc[1] - 1 + loc[1] -loc[0] - 1;
            int min = 2;
            for(int i = 1; i <= 2; i++){
                if(loc[i] - 2 <= loc[i-1]){ // 有一个间隔中间只差一个或0个 1 3 5 ,min = 1
                    min = 1;
                }
            }
            if(loc[2] - loc[1] == 1 && loc[1] -loc[0] == 1){
                min = 0;
            }
            return new int[]{min,max};
        }
    }
}
