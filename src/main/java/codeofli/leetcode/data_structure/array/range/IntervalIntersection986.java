package codeofli.leetcode.data_structure.array.range;

import java.util.ArrayList;
import java.util.List;

public class IntervalIntersection986 {
    /**
     * 每个区间列表都是成对 不相交 的，并且 已经排序 。
     */
    public int[][] intervalIntersection(int[][] firstList, int[][] secondList) {
        List<int[]> res = new ArrayList<>();
        for (int i = 0; i < firstList.length; i++) {
            int s1 = firstList[i][0], e1 = firstList[i][1];
            for (int j = 0; j < secondList.length; j++) {
                int s2 = secondList[j][0], e2 = secondList[j][1];
                if (e2 < s2) { //后面的肯定不想交了
                    break;
                } else if (s1 <= e2 && s2 <= e1) {
                    int min = Math.max(s1, s2);
                    int max = Math.min(e1,e2);
                    res.add(new int[]{min,max});
                }
            }
        }
        return res.toArray(new int[0][0]);
    }
}
