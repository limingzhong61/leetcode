package exam.old.dj.t3;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

// 注意类名必须为 Main, 不要有任何 package xxx 信息
public class Main {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        long x = in.nextLong();
        long y = in.nextLong();
        int[] bx = getBinArray(x);
        int[] by = getBinArray(y);
        for(int i = 0; i <= 64; i++){
            if(by[i] == 1 && bx[i] != 1){
                System.out.println(-1);
                return;
            }else if(bx[i] == 1){
                break;
            }
        }


        ArrayList<Long> canSubs = new ArrayList<>();
        for(int i = 63; i >= 0; i--){
            if(bx[i] == 1){
                canSubs.add((1L << i));
            }
        }
        if(y == x){
            return;
        }
        ArrayList<Long> ans = new ArrayList<>();
        if(y > x){
            long diff = y - x;
            while(diff > 0){
                for(long sub : canSubs){
                    if(diff >= sub){
                        ans.add(sub);
                        diff -= sub;
                        break;
                    }
                }
            }

            System.out.println(ans.size());
            for(int i = 0; i < ans.size(); i++){
                System.out.printf("+ %d\n",ans.get(i));
            }
        }else{
            long diff = x - y;
            while(diff > 0){
                for(long sub : canSubs){
                    if(diff > sub){
                        //System.out.printf("- %d\n",sub);
                        diff -= sub;
                        break;
                    }
                }
            }

            System.out.println(ans.size());
            for(int i = 0; i < ans.size(); i++){
                System.out.printf("- %d\n",ans.get(i));
            }
        }
    }

    private static int[] getBinArray(long x) {
        int[] bx = new int[65];
        for(int i = 0; i <= 64; i++){
            if((x & (1L << i)) != 0){
                bx[i] = 1;
            }
        }
        return bx;
    }
}