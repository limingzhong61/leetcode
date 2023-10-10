package exam.old.shein.t2;
//package main
//注意不要添加包名称，否则会报错。

import java.util.Scanner;


// 注意类名必须为 Main, 不要有任何 package xxx 信息
public class Main {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        String line = in.next();
        String[] split = line.split(",");
        char[] cs = split[0].toCharArray();
        int row = Integer.parseInt(split[1]);
        char[][] trans = new char[row*2][row];
        int colIdx = 0;
        for (int idx = 0; idx < cs.length; ) {
            if (colIdx % 2 == 0) {
                for (int j = 0; j < row; j++) {
                    trans[colIdx][j] = cs[idx++];
                    if (idx >= cs.length) break;
                }
            } else {
                for (int j = row - 2; j >= 1; j--) {
                    trans[colIdx][j] = cs[idx++];
                    if (idx >= cs.length) break;
                }
            }
            colIdx++;
        }

        for (int i = 0; i < row; i++) {
            for (int j = 0; j <2 * row; j++) {
                if (trans[j][i] != 0)
                    System.out.printf(String.valueOf(trans[j][i]));
            }
        }
    }
}
/**
 SHEINFORALL,4
 SOHFRENALILD

 SHEINFORALL,3
 SNAHIFRLEOL
 */