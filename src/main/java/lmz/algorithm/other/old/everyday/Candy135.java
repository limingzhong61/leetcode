package lmz.algorithm.other.old.everyday;

import java.util.Arrays;

public class Candy135 {
    /**
     * 空间为1的解法
     * 关键点在于：当下降序列的长度超过上升序列时，下降序列中包裹山顶都需要补1
     */
    public int candy(int[] ratings) {
        int n = ratings.length;
        int ret = 1;
        int inc = 1, dec = 1, pre = 1;                              // inc和dec都统一从1开始
        for (int i = 1; i < n; i++) {
            if (ratings[i] >= ratings[i - 1]) {
                dec = 1;
                pre = ratings[i] == ratings[i - 1] ? 1 : pre + 1;
                ret += pre;
                inc = pre;
            } else {
                dec++;
                if (dec >= inc + 1) {     //  dec长度已经大于inc，山顶那个点不够大了，也需要增高1点
                    ret+= dec;
                }else{
                    ret+= dec-1;
                }
                pre = 1;
            }
        }
        return ret;
    }

    /**
     * 分发糖果数为最长递增序列的长度最大值
     * f1[i] 为i结尾的从左到右最长递增序列长度
     * f2[i] 为i结尾的从右到左最长递增序列长度
     * candy[i] = max(f1[i],f2[i]);
     */
    public int candy2(int[] ratings) {
        int res = 0;
        //1 <= n <= 2 * 104
        int n = ratings.length;
        int[] f1 = new int[n];
        Arrays.fill(f1, 1);
        for (int i = 1; i < n; i++) {
            if (ratings[i] > ratings[i - 1]) {
                f1[i] = f1[i - 1] + 1;
            }
        }
        int[] f2 = new int[n];
        Arrays.fill(f2, 1);
        for (int i = n - 2; i >= 0; i--) {
            if (ratings[i] > ratings[i + 1]) {
                f2[i] = f2[i + 1] + 1;
            }
            res += Math.max(f2[i],f1[i]);
        }
        return res;
    }
}
