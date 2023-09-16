package exam.sxf.t1;


import java.util.Scanner;

// 注意类名必须为 Main, 不要有任何 package xxx 信息
public class Main {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        String s = in.next();
        if(s.length() > 255){
            System.out.println(false);
            return;
        }
        String[] split = s.split("\\.");
        if(split.length < 2){
            System.out.println(false);
            return;
        }
        for(String x : split){
            char[] cs = x.toCharArray();
            if(cs.length > 63 || cs.length == 0){
                System.out.println(false);
                return;
            }
            if(cs[0] == '-' || cs[cs.length-1] == '-'){
                System.out.println(false);
                return;
            }
            for(int i = 0; i < cs.length; i++){
                if(!(Character.isLetter(cs[i]) || Character.isDigit(cs[i]) || cs[i] == '-')){
                    System.out.println(false);
                    break;
                }
            }
        }
        System.out.println(true);
    }
}
