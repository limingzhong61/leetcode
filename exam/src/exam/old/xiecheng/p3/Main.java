package exam.old.xiecheng.p3;// 本题为考试单行多行输入输出规范示例，无需提交，不计分。


import java.util.HashSet;
import java.util.Scanner;

public class Main {
    static int ans = 0;

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int t = in.nextInt();
        for (int a = 0; a < t; a++) {
            int n = in.nextInt();
            long l = in.nextInt();
            long r = in.nextInt();
            //long sum = 0;
            long minAdd = 0, minSub = 0;
            long maxAdd = 0, maxSub = 0;
            for (int i = 0; i < n; i++) {
                int x = in.nextInt();
                //sum += x;
                minAdd += Math.max(l - x, 0);
                maxAdd += Math.max(r - x, 0);

                minSub += Math.max(x - r, 0);
                maxSub += Math.max(x - l, 0);
            }
            if (minAdd <= maxSub && minSub <= maxAdd) {
                System.out.println(Math.max(minAdd, minSub));
            } else {
                System.out.println(-1);
            }
        }
    }

}
/**
 * 2
 * 2 3 5
 * 1 2
 * 3 4 6
 * 3 6 5
 */