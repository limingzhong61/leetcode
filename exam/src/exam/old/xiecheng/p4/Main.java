package exam.old.xiecheng.p4;// 本题为考试单行多行输入输出规范示例，无需提交，不计分。



import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        char[] cs = in.next().toCharArray();
        int n = cs.length;
        long ans = 0;
        for(int i = 0; i < n; i++){
            int cnt0 = 0;
            int cnt1 = 0;
            for(int j = i; j < n; j++){
                if(cs[j] == '0'){
                    cnt0++;
                }else{
                    cnt1++;
                }
                if(cnt0 > cnt1){
                    if(i == 0 && j == n-1 ){
                        continue;
                    }
                    ans++;
                    //System.out.printf("%d,%d\n",i+1,j+1);
                }else{
                    break;
                }


            }
        }
        System.out.println(ans);
    }
}