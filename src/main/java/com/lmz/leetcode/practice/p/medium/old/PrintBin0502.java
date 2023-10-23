package com.lmz.leetcode.practice.p.medium.old;

/**
 * @author: limingzhong
 * @create: 2023-03-02 13:12
 */
public class PrintBin0502 {
    /**
     * 将分数转为整数计算
     */
    public String printBin(double num) {
        long ff = 0, fm = 1;
        while (Math.abs(num - ff) > 1e-5) {
            fm *= 10;
            num *= 10;
            ff = (int) Math.round(num);
            //System.out.printf("%d,%d,%f\n", fm, ff,num);
        }
        //System.out.printf("%d,%d\n", fm, ff);
        int pos = 30;
        long base = 2;
        StringBuilder res = new StringBuilder("0.");
        for (int i = 1; i < pos; i++) {
            if (base > fm || ff == 0) break;
            // System.out.println(base);
            if (fm % base != 0) break; //不能整除
            long x = fm / base;
            if (ff >= x) {
                ff -= x;
                res.append(1);
            } else {
                res.append(0);
            }
            base *= 2;
            // System.out.printf("%d\n", ff);
        }
        return ff == 0 ? res.toString() : "ERROR";
    }
}
