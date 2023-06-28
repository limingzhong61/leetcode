package lmz.algorithm.dp.not_usual;

/**
 * @author: limingzhong
 * @create: 2023-01-03 16:11
 */
public class CountBits338 {
    /**
     * dp-最高有效位
     */
    public int[] countBits(int n) {
        int[] bits = new int[n + 1];
        int highBit = 0;
        for (int i = 1; i <= n; i++) {
            if ((i & (i - 1)) == 0) {
                highBit = i;
            }
            bits[i] = bits[i - highBit] + 1;
        }
        return bits;
    }

    public int[] countBits1(int n) {
        int[] res = new int[n + 1];
        res[0] = 0;
        res[1] = 1;
        int pow2 = 1;
        for(int i = 1; i < n; i++){
            if(pow2 * 2 == i){
                res[i] = 1;
                pow2 *= 2;
                continue;
            }
            res[i] = res[pow2] + res[i - pow2];
        }
        return  res;
    }
}
