//package meituan.t1.t11;
//
///**
// * @author: limingzhong
// * @create: 2023-04-01 11:10
// */
//
//import java.io.*;
//import java.util.Scanner;
//
//public class exam.Main {
//    public static void main(String args[]) throws IOException {
//        BufferedReader cin = new BufferedReader(new InputStreamReader(System.in));
//        PrintWriter pw = new PrintWriter(new BufferedWriter(new OutputStreamWriter(System.out)));
//        int m, n;
//        String line;
//        line = cin.readLine();
//        n = Integer.parseInt(line);
//        int[] da = new int[n];
//
//        line = cin.readLine();
//        String[] split = line.split(" ");
//        for (int i = 0; i < n; i++) {
//            da[i] = Integer.parseInt(split[i]);
//        }
//
//        line = cin.readLine();
//        m = Integer.parseInt(line);
//        line = cin.readLine();
//        split = line.split(" ");
//
//        for (int i = 0; i < split.length; i += 2) {
//            // lo1-1,loc
//            int loc = Integer.parseInt(split[i]);
//            char opt = split[i + 1].charAt(0);
//            double res = 0;
//            double t = 0;
//            if (opt == '*') {
//                t = da[loc - 1] * da[loc];
//            } else if (opt == '/') {
//                t = (double) da[loc - 1] / da[loc];
//            } else if (opt == '+') {
//                t = da[loc - 1] + da[loc];
//            } else if (opt == '-') {
//                t = da[loc - 1] - da[loc];
//            }
//            for (int j = 0; j < n; j++) {
//                if (j == loc - 1 || j == loc) continue;
//                res += da[j];
//            }
//            res += t;
//            pw.printf("%.1f ", res);
//        }
//        cin.close();
//        //pw.println();
//        pw.close();//有close才有最后的输出
//    }
//}
