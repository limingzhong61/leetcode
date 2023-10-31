package exam.old.lian_tong.t1;
//package main
//注意不要添加包名称，否则会报错。


import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String name = reader.readLine();
        System.out.println(name.substring(1,name.length()-1));
        String[] split = name.substring(1,name.length()-1).split(",");
        int[] nums = new int[split.length];
        int idx = 0;
        for(String s : split){
            nums[idx++] = Integer.parseInt(s);
        }
        int target = Integer.parseInt(reader.readLine() );
        new Solution().twoSum(nums,target);
    }
}

class Solution {
    public void twoSum(int[] nums, int target) {
        HashMap<Integer,Integer> map = new HashMap<>();
        for(int i = 0; i < nums.length; i++){
            int x = nums[i];
            if(map.containsKey(target - x)){
                System.out.printf("%d,%d",Math.min(i,map.get(target -x)),Math.max(i,map.get(target -x)));
                return;
            }
            map.put(x,i);
        }
    }
}
/**
[3,2,4]
6

1,2
 */
