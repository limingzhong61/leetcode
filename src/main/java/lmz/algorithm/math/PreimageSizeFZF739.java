package lmz.algorithm.math;

public class PreimageSizeFZF739 {
    /**
     * 统计质因子5的个数+二分查找
     */
    public int preimageSizeFZF(int k) {
        return (int) (help(k + 1) - help(k));
    }

    public long help(int k) {
        long r = 5L * k;
        long l = 0;
        while (l <= r) {
            long mid = (l + r) / 2;
            if (cnt5(mid) < k) {
                l = mid + 1;
            } else {
                r = mid - 1;
            }
        }
        return r + 1;
    }

    long cnt5(long x) {
        long cnt5 = 0;
        while (x != 0) {
            x /= 5;
            cnt5 += x;
        }
        return cnt5;
    }


    /**
     * 超时：因为逐个求10^9结尾0，则遍历一定会很大
     * 阶乘逐个累乘，最终结尾的零一定最终会超过一个阈值k
     * 因为结尾的零不影响后面的计算，可以提取出来，同理，
     * 乘积product的前面几位也不影响零的计算，可以只取后面几位，防止数值溢出
     */
    public int preimageSizeFZF1(int k) {
        int res = 0;
        int cntZero = 0;
        long start = 1, product = 1;
        int MOD = 100000000;
        while (cntZero <= k) {
            if (cntZero == k) {
                res++;
            }
            while (product % 10 == 0) {
                cntZero++;
                product /= 10;
            }
            start++;
            product *= start;
            product %= MOD;
        }
        return res;
    }

    public static void main(String[] args) {
        PreimageSizeFZF739 preimageSizeFZF739 = new PreimageSizeFZF739();
        System.out.println(preimageSizeFZF739.preimageSizeFZF(1));
    }
}
