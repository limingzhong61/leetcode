package lmz.leetcode.other.easy.old;

import java.util.stream.IntStream;

/**
 * @author: codeofli
 * @create: 2022-11-22 10:08
 */
public class MaximumWealth1672 {
    public int maximumWealth(int[][] accounts) {
        int max = 0;
        for(var arr : accounts){
            max = Math.max(max, IntStream.of(arr).sum());
        }
        return max;
    }
}
