package exam.old.dj.t1;


import java.util.Scanner;

// 注意类名必须为 Main, 不要有任何 package xxx 信息
public class Main {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int m = in.nextInt();
        int H = in.nextInt();
        int[] h = new int[n];
        int[] p = new int[n];
        int[] s = new int[m+1];
        for(int i = 0; i < n; i++){
            h[i] = in.nextInt();
        }
        for(int i = 0; i < n; i++){
            p[i] = in.nextInt();
        }

        int maxS = 0;
        for(int i = 1; i <= m; i++){
            s[i] = in.nextInt();
            maxS = Math.max(maxS,s[i]);
        }

        for(int i = 0; i < n; i++){
            h[i] += s[p[i]];
        }

        H += maxS;
        int ans = 0;
        for(int i = 0; i < n; i++){
            if(H > h[i]){
                ans++;
            }
        }
        System.out.println(ans);
    }
}
