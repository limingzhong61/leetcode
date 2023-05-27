package lmz.algorithm.other.medium;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
 * @author: limingzhong
 * @create: 2023-05-23 15:18
 */
public class LargestValsFromLabels1090 {
    class Solution {
        public int largestValsFromLabels(int[] values, int[] labels, int numWanted, int useLimit) {
            List<int[]> list = new ArrayList<>();
            int n = values.length;
            for (int i = 0; i < n; i++) {
                int[] temp = {values[i], labels[i]};
                list.add(temp);
            }

            list.sort((a, b) -> {
                return b[0] - a[0];
            });
            HashMap<Integer,Integer> cntMap = new HashMap<>();
            int wanted = 0;
            int sum = 0;
            //labels[i] <= 2 * 10^4
            for (int i = 0; i < n; i++) {
                int[] ints = list.get(i);
                int value = ints[0];
                int label = ints[1];
                if (cntMap.getOrDefault(label,0) < useLimit) {
                    cntMap.put(label, cntMap.getOrDefault(label,0)+1) ;
                    sum += value;
                    wanted++;
                    if (wanted == numWanted) {
                        break;
                    }
                }
            }
            return sum;
        }
    }
}
