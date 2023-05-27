package lmz.algorithm.other.medium;

/**
 * @author: limingzhong
 * @create: 2023-05-27 9:44
 */
public class SampleStats1093 {
    /**
     * 我们对 0 到 255 之间的整数进行采样
     * 统计 中位数时，直接用left，right表示idx的范围
     */
    public double[] sampleStats(int[] count) {
        int n = count.length;
        double minimum = Integer.MAX_VALUE,maximum = Integer.MIN_VALUE,mean = 0,mode = 0;
        int maxCount = 0;
        int total = 0;
        for(int i = 0; i < n; i++){
            int x = count[i];
            if(x <= 0) continue;
            maximum = Math.max(maximum,i);
            minimum = Math.min(minimum,i);

            mean += x*1.0 * i;
            if(x > maxCount){
                maxCount = x;
                mode = i;
            }
            total += x;
        }
        mean /= total;

        double median  = 0;
        int left = (total + 1) / 2;
        int right = (total + 2) / 2;
        int cnt = 0;
        for(int i = 0; i < n; i++){
            if (cnt < right && cnt + count[i] >= right) {
                median += i;
            }
            if (cnt < left && cnt + count[i] >= left) {
                median += i;
            }
            cnt += count[i];
        }
        median = median / 2.0;
        return new double[]{minimum,maximum,mean,median,mode};
    }
}
