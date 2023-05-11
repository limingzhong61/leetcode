package old.webank.t3;
//package main
//注意不要添加包名称，否则会报错。

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;


public class Main {
    public static void main(String args[]) {
        Scanner cin = new Scanner(System.in);
        int t = cin.nextInt();
        for (int a = 0; a < t; a++) {
            int n = cin.nextInt();
            //(ai∈[1,4095]
            int[] nums = new int[n];
            for(int i = 0; i < n; i++){
                nums[i] = cin.nextInt();
            }
            Arrays.sort(nums);
            ArrayList<Integer> list = new ArrayList<>();
            for(int i = 0; i < n; i++){
                if(nums[i] == 0) continue;
                list.add(nums[i]);
                for(int j = i+1; j < n; j++){
                    if((nums[j] & nums[i]) == nums[i]){
                        nums[j] ^= nums[i];
                    }
                }
            }
            System.out.println(list.size());
            for(int i = 0; i < list.size(); i++){
                System.out.printf("%d ",list.get(i));
            }
        }

    }
}
