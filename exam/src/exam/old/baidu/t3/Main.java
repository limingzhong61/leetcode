package exam.old.baidu.t3;


import java.util.HashSet;
import java.util.Scanner;

// 注意类名必须为 Main, 不要有任何 package xxx 信息
public class Main {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int q = in.nextInt();
        HashSet<String> set = new HashSet<>();
        HashSet<String> fNameSet = new HashSet<>();
        for(int k = 0; k < q; k++){
            int op = in.nextInt();
            in.nextLine();
            String f = in.nextLine();
            // 去掉 “）”
            f = f.substring(0,f.length() - 1);
            //System.out.println(f);
            if(op == 1){

                String[] split = f.split("[ (,]");
                StringBuilder sb = new StringBuilder();
                sb.append(split[1]);
                String fName = split[1];
                fNameSet.add(fName);
                for(int i = 2; i < split.length - 1; i+= 2){
                    sb.append("-").append(split[i]);
                }
                if(set.contains(sb.toString())){
                    System.out.printf("method %s is already defined.",fName);
                }else{
                    set.add(sb.toString());
                    System.out.println("ok.");
                }
                //System.out.println();
                //System.out.println(fName);
                //System.out.println(sb.toString());
                //System.out.println();
            }else{

                StringBuilder sb = new StringBuilder();
                String[] split = f.split("[\\(,]");
                sb.append(split[0]);
                String fName = split[0];
                for(int i = 1; i < split.length; i++){
                    sb.append("-").append(split[i]);
                }
                //System.out.println();
                //System.out.println(fName);
                //System.out.println(sb.toString());
                //System.out.println();
                if(!fNameSet.contains(fName)){
                    System.out.printf("cannot find symbol %s.\n",fName);
                }else if(!set.contains(sb.toString())){
                    System.out.printf("method %s cannot be applied to given types.\n",fName);
                }else{
                    System.out.println("ok.");
                }
            }
        }

        System.out.println();
    }
}
/**
7
1
int f(int x)
1
int g(int x,String s)
2
f()
1
void f(double x,double y)
2
f(double,double)
2
solve(int,String)
1
void f(int y)



 */


/**
ok.
ok.
method f cannot be applied to given types.
ok.
ok.
cannot find symbol solve.
method f is already defined.
 */