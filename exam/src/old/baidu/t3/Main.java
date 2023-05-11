//<<<<<<< HEAD
//package meituan.t3;
////package main
////注意不要添加包名称，否则会报错。
//
//import java.util.Arrays;
//import java.util.HashSet;
//import java.util.Scanner;
//import java.util.Set;
//
//public class Main {
//    public static void main(String args[]) {
//        Scanner cin = new Scanner(System.in);
//        int n, m, s;
//        while (cin.hasNextInt()) {
//            n = cin.nextInt();
//            m = cin.nextInt();
//            s = cin.nextInt();
//            int[] nums = new int[n + 1];
//            for (int i = 1; i <= n; i++) {
//                nums[i] = cin.nextInt();
//            }
//            // f表示[0,i]的最小值
//            long[] f = new long[n + 1];
//            Arrays.fill(f, Long.MAX_VALUE);
//            f[0] = 0;
//            for (int i = 1; i <= n; i++) {
//                int u = -1, v = Integer.MAX_VALUE;
//                //long sum = 0;
//                for (int j = i; j >= 1; j--) {
//                    u = Math.max(u, nums[j]);
//                    v = Math.min(v, nums[j]);
//                    //sum += nums[j];
//                    //long bagCnt = sum / m;
//                    //if (sum % m != 0) bagCnt++; // 有多余的需要放
//                    int len = i - j + 1; // 装入水果数量
//                    f[i] = Math.min(f[i], (f[j - 1] + s + len * (long) Math.floor((u + v) * 1.0 / 2)));
//                }
//            }
//            System.out.println(f[n]);
//        }
//    }
//}
//=======
//package baidu.t3;
//// 本题为考试单行多行输入输出规范示例，无需提交，不计分。
//
//import java.util.HashSet;
//import java.util.Scanner;
//import java.util.Set;
//
//public class Main {
//    public static void main(String[] args) {
//        Scanner in = new Scanner(System.in);
//        while (in.hasNextInt()) {// 注意，如果输入是多个测试用例，请通过while循环处理多个测试用例
//            int n = in.nextInt();
//            Set<String> set = new HashSet<>();
//            String line1 = in.nextLine();
//            for(int i = 0; i < n; i++){
//                String line = in.nextLine();
//
//                //String s = line.replaceAll("\\w+[,\\\\)]", "");
//                String[] split = line.split("[ ,\\\\(]");
//                StringBuilder sb = new StringBuilder();
//                sb.append(split[1]);
//                for(int j = 2; j < split.length;j+= 2){
//                    sb.append(split[j]);
//                }
//                if(!set.contains(sb.toString())){
//                    set.add(sb.toString());
//                    System.out.println("Yes");
//                }else{
//                    System.out.println("No");
//                }
//            }
//        }
//    }
//}
//
//>>>>>>> f0707b453829379a33caafde07df465824c3cc1b
