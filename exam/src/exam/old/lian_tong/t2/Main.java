package exam.old.lian_tong.t2;

import java.io.*;
import java.math.BigDecimal;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String name = reader.readLine();
        Solution s = new Solution();
        s.climbStairs(Integer.parseInt(name));
        //s.climbStairs(Integer.MAX_VALUE);
    }
}

class Solution {
    public void climbStairs(int n) {
        if(n == 1 || n == 2){
            System.out.println(n);
            return;
        }
        //long[] f = new long[n+1];
        //f[1] = 1;
        //f[2] = 2;
        //long f1 = 1, f2 = 2,f3 = 0;
        BigDecimal f1 = new BigDecimal(1);
        BigDecimal f2 = new BigDecimal(2);
        BigDecimal f3 = new BigDecimal(0);
        for(int i = 3; i <= n; i++){
            //f[i] = f[i-1] + f[i-2];
            f3 = f2.add(f1);
            f1 = f2;
            f2 = f3;
        }
        System.out.println(f3);
    }
}