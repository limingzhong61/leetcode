package lmz.algorithm.contest.old.c317;

/**
 * @author: codeofli
 * @create: 2022-10-30 10:31
 */
public class AverageValue {
    public int averageValue(int[] nums) {
        int sum = 0,cnt = 0;
        for(int i : nums){
            if(i != 0 && i % 6 == 0){
                sum += i;
                cnt++;
            }
        }
        if(cnt == 0){
            return 0;
        }
        return  sum / cnt;
    }
}
