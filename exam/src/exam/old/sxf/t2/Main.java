package exam.old.sxf.t2;



import java.util.Scanner;

// 注意类名必须为 Main, 不要有任何 package xxx 信息
public class Main {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        String s = in.next();
        String p = in.next();
        if(s.matches(p)){
            System.out.println(1);
        }else{
            System.out.println(0);
        }
    }
}