package codeofli.leetcode.graph_parse_ds.math;

import codeofli.my.leetcode.StringTransformUtil;

import java.util.Arrays;

public class ConstructArr66 {
    /**
     *
     * 题目要求不能使用除法。
     */
    public int[] constructArr(int[] a) {
        if(a == null || a.length == 0){
            return new int[0];
        }
        int n = a.length;
        int[] left  = new int[n],right = new int[n];
        left[0] = right[n-1] = 1;
        for(int i = 1; i < n; i++){
            left[i] = left[i-1] * a[i-1];
        }
        for(int i = n-2; i >= 0; i--){
            right[i] = right[i+1] * a[i+1];
        }
        for(int i = 0; i < n; i++){
            left[i] *= right[i];
        }
        return left;
    }
    /**
     * 先求总的乘积mul=a[0]*a[1]...*a[n-1],则res[i] = mul/res[i](数组中有0特殊讨论)
     * 题目要求不能使用除法。
     */
    public int[] constructArr1(int[] a) {
        //所有元素乘积之和不会溢出 32 位整数
        int mul = 1;
        int zeroCnt = 0;
        int n = a.length;
        int[] res = new int[n];
        int zeroIndex = 0;
        for(int i = 0; i < n; i++){
            if(a[i] == 0){
                zeroCnt++;
                //存在两个0，则数组全为0
                if(zeroCnt == 2){
                    return res;
                }
                zeroIndex = i;
                continue;
            }
            mul *= a[i];
        }
        //a[]中只有一个0
        if(zeroCnt == 1){
            res[zeroIndex] = mul;
            return res;
        }

        for(int i = 0; i < n; i++){
            res[i] = mul / a[i];
        }
        return  res;
    }

    public static void main(String[] args) {
        ConstructArr66 constructArr66 = new ConstructArr66();

        System.out.println(Arrays.toString(constructArr66.constructArr(StringTransformUtil.toIntArray("[1,2,3,4,5]"))));
        System.out.println(Arrays.equals(constructArr66.constructArr(StringTransformUtil.toIntArray("[1,2,3,4,5]")),
            StringTransformUtil.toIntArray("[120,60,40,30,24]")));

        System.out.println(Arrays.toString(constructArr66.constructArr(StringTransformUtil.toIntArray("[1, 2, 0, 4, 5]"))));
        System.out.println(Arrays.equals(constructArr66.constructArr(StringTransformUtil.toIntArray("[1, 2, 0, 4, 5]")),
            StringTransformUtil.toIntArray("[0,0,40,0,0]")));
    }
}
