package codeofli.leetcode.primary.math;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class CountPrimes204 {
    /**
     * leetcode:
     * 线性筛选
     */
    public int countPrimes(int n) {

        List<Integer> primes = new ArrayList<>((int)Math.floor(Math.sqrt(n)));
        boolean[] isPrime = new boolean[n];
        Arrays.fill(isPrime,false);

        for(int i = 2;i < n; i++){
            if(isPrime[i]){
                primes.add(i);
            }
            for(int j = 0;j< primes.size() && i * primes.get(j) < n; j++){
                isPrime[i * primes.get(j)] = false;
                if(i % primes.get(j) == 0){
                    break;
                }
            }
        }
        return primes.size();
    }

    public int countPrimes1(int n) {
        int cnt = 0;
        for (int i = 2; i < n; i++) {
            if (isPrime(i)) {
                cnt++;
            }
        }
        return cnt;
    }

    public boolean isPrime(int x) {
        for (int i = 2; i * i <= x; i++) {
            if (x % i == 0) {
                return false;
            }
        }
        return true;
    }
    /**
     * my:素数筛选
     * 注意：返回 所有小于非负整数 n 的质数的数量
     */
    public int countPrimes2(int n) {
        //if (n < 2) {//0，1本身就不是素数
        //    return 0;
        //}
        boolean[] isPrime = new boolean[n];
        Arrays.fill(isPrime, true);
        int cnt = 0;
        for (int i = 2; i < n; i++) {
            if (isPrime[i]) { //i是素数
                cnt++;
                if ((long) i * i < n) { //防止i*i越界,i*i之前的都被标记了：2*i,3*i...
                    for (int j = i * i; j < n; j += i) { //i的倍数不是素数。
                        isPrime[j] = false;
                    }
                }
            }
        }
        return cnt;
    }


}
