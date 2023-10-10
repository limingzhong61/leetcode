package exam.old.duxiaomang.t3;
//package main
//注意不要添加包名称，否则会报错。

import java.util.Scanner;


public class Main {
    public static void main(String args[]) {
        Scanner cin = new Scanner(System.in);
        int n = cin.nextInt();
        int m = cin.nextInt();
        int[] a = new int[n];
        int[] b = new int[m+1];

        for(int i = 0; i < n; i++){
            a[i] = cin.nextInt();
        }

        int cnt = 0;
        for(int i = 1; i <= m; i++){
            b[i] = cin.nextInt();
            if(b[i] > 0) cnt++;
        }
        int left = 0;
        int ans = n + 1;
        for(int right = 0; right < n; right++){
            if(a[right] > m) continue;
            if(b[a[right]] == 1){
                cnt--;
            }
            b[a[right]]--;
            while(cnt == 0 && left <= right){
                if(b[a[left]] == 0){
                    //System.out.printf("%d,%d\n",left,right);
                    ans = Math.min(right - left + 1, ans);
                    cnt++;
                }
                b[a[left++]]++;
            }

        }
        System.out.println(ans == n+1 ? -1 : ans);
    }
}
/**

 5 3
 2 2 1 2 2
 1 0 0

 5 3
 1 2 2 2 2
 1 0 0

 5 3
 2 2 2 2 1
 1 0 0


 5 3
 1 1 1 1 1
 3 0 0

 5 3
 2 3 3 1 2
 3 2 2

 5 3
 2 3 3 1 2
 1 2 2

 5 3
 2 3 3 1 2
 1 0 0

 8 5
 2 3 3 1 2 4 2 5
 1 0 0 0 0

 8 5
 2 3 3 1 2 4 2 5
 1 2 0 0 0
 */