package exam.old.xiecheng.p2;// 本题为考试单行多行输入输出规范示例，无需提交，不计分。


import java.util.HashMap;
import java.util.HashSet;
import java.util.Scanner;

public class Main {
    static int ans = 0;

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int m = in.nextInt();
        char[][] cs = new char[n][m];
        for (int i = 0; i < n; i++) {
            cs[i] = in.next().toCharArray();
        }
        HashMap<Character, Integer> map = new HashMap<>();
        map.put('y', 0);
        map.put('o', 1);
        map.put('u', 2);
        // i行前缀和
        int[][] cnt1 = new int[n][3];
        char[] tri = new char[]{'y', 'o', 'u'};
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                for (int k = 0; k < 3; k++) {
                    if (cs[i][j] == tri[k]) {
                        cnt1[i][k]++;
                    }
                }
            }
        }

        // i列前缀和
        int[][] cnt2 = new int[m][3];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                for (int k = 0; k < 3; k++) {
                    //System.out.println(i);
                    //System.out.println(j);
                    //System.out.println("---");
                    if (cs[j][i] == tri[k]) {
                        cnt2[i][k]++;
                    }
                }
            }

        }

        long ans = 0;

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                for (int k = 0; k < 3; k++) {
                    if (cs[i][j] == tri[k]) {
                        char c1 = tri[(k + 1) % 3];
                        char c2 = tri[(k - 1 + 3) % 3];
                        long o = cnt1[i][map.get(c1)];
                        long u = cnt2[j][map.get(c2)];
                        ans += o*u;
                        //System.out.printf("%d,%d,%d,\n", i, j,Math.min(o, u));
                        o = cnt1[i][map.get(c2)];
                        u = cnt2[j][map.get(c1)];
                        ans += o*u;
                        //System.out.printf("%d,%d,%d,\n", i, j,Math.min(o, u));
                    }
                }

            }
        }
        System.out.println(ans);
    }

}
/**
 2 3
 you
 our
 */