package exam.meituan.t4;




import java.util.Scanner;

// 注意类名必须为 Main, 不要有任何 package xxx 信息
public class Main {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int m = in.nextInt();
        int[] a = new int[n];
        a[0] = 1;
        int diff = 1;
        StringBuilder sb = new StringBuilder();
        sb.append(a[0]).append(' ');
        //System.out.printf("%d ", a[0]);
        for(int i = 1; i < n; i++){
            int next = a[i-1] + diff;
            // 需要填的个数
            int need = n - i;
            // 后面全为1可填充的最大长度, next,next+1...
            int needMax =  next + need - 1;
            if(m >= needMax){
                a[i] = a[i-1] + diff;
                diff++;
            }else{
                for(int j = i; j < n; j++){
                    a[j] = a[j-1] + 1;
                    //System.out.printf("%d ", a[j]);
                    sb.append(a[j]).append(' ');
                }
                break;
            }
            //System.out.printf("%d ", a[i]);
            sb.append(a[i]).append(' ');
        }
        System.out.println(sb.toString());
    }
}
/**
 4 12
 1 2 4 5


 4 4
 */