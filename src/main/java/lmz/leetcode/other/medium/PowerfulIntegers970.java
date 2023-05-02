package lmz.leetcode.other.medium;

import java.util.ArrayList;
import java.util.List;

/**
 * @author: limingzhong
 * @create: 2023-05-02 10:56
 */
public class PowerfulIntegers970 {
    class Solution {
        public List<Integer> powerfulIntegers(int x, int y, int bound) {
            boolean[] can = new boolean[bound + 1];
            int a = 1;
            for (; a <= bound; ) {

                for (int b = 1; b + a <= bound; b *= y) {
                    can[a+b] = true;
                    if(y == 1) break;
                }
                if(x == 1) break;
                a *= x;
            }
            List<Integer> list = new ArrayList<>();
            for(int i = 0; i <= bound; i++){
                if(can[i]) list.add(i);
            }
            return list;
        }
    }
}
