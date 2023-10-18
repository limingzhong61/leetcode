package com.lmz.algorithm_practice.other.old.primary.math;

import java.util.ArrayList;
import java.util.List;

public class FizzBuzz412 {
    /*answer[i] == "FizzBuzz" 如果 i 同时是 3 和 5 的倍数。
    answer[i] == "Fizz" 如果 i 是 3 的倍数。
    answer[i] == "Buzz" 如果 i 是 5 的倍数。
    answer[i] == i （以字符串形式）如果上述条件全不满足。*/


    public List<String> fizzBuzz(int n) {
        List<String> result= new ArrayList<>();
        for(int i = 1; i <= n; i++){

            if(i % 15 == 0){
                result.add("FizzBuzz");
            }else if(i % 3 == 0){
                result.add("Fizz");
            }else if(i % 5 == 0){
                result.add("Buzz");
            }else {
                result.add(String.valueOf(i));
            }
        }
        return  result;
    }
}
