import java.util.Arrays;

/**
 * @author: limingzhong
 * @create: 2023-04-22 13:39
 */
public class Test {
    public int longestArithSeqLength(int[] nums) {
        int n = nums.length;
        //i,j,以i结尾公差为的j的状态。
        int[][] f = new int[n][1000+1];
        int max = 2;
        Arrays.fill(f[0],1);
        for(int i = 1; i < n; i++){
            // f[i] = 2; // 至少为2
            Arrays.fill(f[i],1);
            for(int j = 0; j < i; j++){
                int diff = nums[j] - nums[i];
                diff += 500;
                f[i][diff] = f[j][diff] + 1;
                max = Math.max(f[i][diff],max);
            }
        }
        return max;
    }
}
