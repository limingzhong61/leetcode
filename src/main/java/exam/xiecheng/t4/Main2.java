package exam.xiecheng.t4;

import java.util.*;

// 注意类名必须为 Main, 不要有任何 package xxx 信息
public class Main2 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        long p = 1;
        int[] a = new int[n];
        int max = 0;
        HashMap<Integer,Integer> map = new HashMap<>();
        for (int i = 0 ; i < n; i++) {
            a[i] = in.nextInt();
            max = Math.max(a[i], max);
            map.put(a[i],map.getOrDefault(a[i],0) + 1);
        }

        List<Integer> primes = new ArrayList<>();
        for (int i = 2; i <= max; i++) {
            boolean is = true;
            for (int j = 0; j < primes.size(); j++) {
                if (i % primes.get(j) == 0) {
                    is = false;
                    break;
                }
            }
            if (is) {
                primes.add(i);
            }
        }
        int[] cnt = new int[primes.size()];
            for (int k = 2; k <= max; k++) {
                int t = k;
                for (int j = 0; j < primes.size(); j++) {
                    int prime = primes.get(j);
                    while (t % prime == 0) {
                        cnt[j]++;
                        t /= prime;
                    }
                    if(t == 1) break;
                }
            }
        long  ans = 1;
        long mod = (long) (1e9 + 7);
        for (int i = 0; i < primes.size(); i++) {
            ans = (ans * (cnt[i] + 1)) % mod;
        }
        // System.out.println(p);
        System.out.println(ans);
    }
}
/**
 * 3
 * 1 2 3
 * <p>
 * <p>
 * 4
 * 1 2 3 4
 * <p>
5
1 2 3 4 5
 */