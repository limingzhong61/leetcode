package codeofli.leetcode.other.easy.old;

import java.util.stream.IntStream;
import java.util.stream.LongStream;

public class ChalkReplacer1894 {
    public int chalkReplacer(int[] chalk, int k) {
        long sum = 0;
        for(int x : chalk){
            sum += x;
        }
        k %= sum;
        for(int i = 0; i < chalk.length; i++){
            k -= chalk[i];
            if(k < 0){
                return i;
            }
        }
        return -1;
    }
}
