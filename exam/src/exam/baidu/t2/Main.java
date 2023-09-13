package exam.baidu.t2;

import java.util.Scanner;

// 注意类名必须为 Main, 不要有任何 package xxx 信息
public class Main {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int k = in.nextInt();
        int[] a= new int[n];
        for(int i = 0; i < n; i++){
            a[i] = in.nextInt();
        }

        for(int b = 0; b < n; b++){
            int start = a[b];
            for(int c = 0; c < k && c+b < n; c++){
                if(start != a[c+b]){
                    break;
                }
                start++;
            }
            if(start - a[b] == k - 1){
                //System.out.printf("%d,%d\n",b,start);
                System.out.println("YES");
                System.out.println(0);
                return;
            }
        }

        for(int i = 0; i < n; i++){
            for(int j = 0; j < n; j++){
                swap(a,i,j);
                for(int b = 0; b < n; b++){
                    int start = a[b];
                    for(int c = 0; c < k && c+b < n; c++){
                        if(start != a[c+b]){
                            break;
                        }
                        start++;
                    }
                    if(start - a[b] == k - 1){
                        System.out.println("YES");
                        System.out.println(1);
                        System.out.printf("%d,%d\n",i+1,j+1);
                        return;
                    }
                }
                swap(a,i,j);
            }
        }


    }

    private static void swap(int[] a, int i, int j) {
        int t = a[i];
        a[i] = a[j];
        a[j] = t;
    }
}
