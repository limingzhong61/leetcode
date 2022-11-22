package codeofli.leetcode.other.everyday.math;

public class NumPrimeArrangements1175 {
    /**
     * 统计质数个数cntPrime
     则答案就是质数位置全排列+非质数位置全排列
     即 (cntPrime)! + (n-cntPrime)!
     */
    public int numPrimeArrangements(int n) {
        int cntPrime = n-1;
        for (int i = 2; i <= n; i++) {
            for (int j = 2; j * j <= i; j++) {
                if (i % j == 0) {
                    cntPrime--;
                    break;
                }
            }
        }
        return (int) (factorial(cntPrime) * factorial(n-cntPrime) % MOD);
    }
    private static  final int MOD = 1000000000 + 7;
    private long factorial(int cntPrime) {
        long res = 1;
        for(int i = 2; i <= cntPrime; i++){
            res  = res * i % MOD;
        }
        return res;
    }

    public static void main(String[] args) {
        NumPrimeArrangements1175 numPrimeArrangements1175 = new NumPrimeArrangements1175();

        //System.out.println(numPrimeArrangements1175.numPrimeArrangements(5));
        //System.out.println(numPrimeArrangements1175.numPrimeArrangements(5) == 12);

        System.out.println(numPrimeArrangements1175.numPrimeArrangements(100));
        System.out.println(numPrimeArrangements1175.numPrimeArrangements(100) == 682289015);
    }
}
