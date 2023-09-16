package exam.old.baidu.t1;


import java.util.Scanner;

// 注意类名必须为 Main, 不要有任何 package xxx 信息
public class Main {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int t = in.nextInt();
        for(int i = 0; i < t; i++){
            int n = in.nextInt();
            int m = in.nextInt();
            int sum = n + m;

            if(sum % 2 == 0 || sum <= 2){
                System.out.println("No");
            }else {
                System.out.println("Yes");
            }
        }

    }
}
