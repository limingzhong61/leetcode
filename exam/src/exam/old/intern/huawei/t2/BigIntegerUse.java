package exam.old.intern.huawei.t2;
//package main
//注意不要添加包名称，否则会报错。

import java.math.BigInteger;
import java.util.Scanner;


public class BigIntegerUse {
    public static void main(String args[]) {
        //System.out.println(Long.MAX_VALUE);
        Scanner cin = new Scanner(System.in);
        String m = cin.next();
        int len = m.length();
        long n = cin.nextLong();
        BigInteger y =  BigInteger.valueOf(n);
        String opt = cin.next();
        String max = null;
        for (int k = len; k >= 1; k--) {
            long[] copy = new long[k];
            for (int i = 0; i + k <= len; i++) {
                String sub = m.substring(i, i + k);
                BigInteger x = new BigInteger(sub);
                BigInteger result = null;
                if (opt.equals("-")) {
                    result = x.subtract(y);
                } else if (opt.equals("+")) {
                    result = x.add(y);
                } else if (opt.equals("*")) {
                    result = x.multiply(y);
                }
                String s = result.toString();
                char start = s.charAt(0);
                boolean allSame = true;
                for(char c : s.toCharArray()){
                    if(c != start){
                        allSame = false;
                        break;
                    }
                }
                if(allSame){
                    if(max == null){
                        max = sub;
                    }else if(max.compareTo(s) < 0){
                        max = sub;
                    }
                }

            }
            if(max != null){
                break;
            }
        }
        System.out.println(max);
    }
}















