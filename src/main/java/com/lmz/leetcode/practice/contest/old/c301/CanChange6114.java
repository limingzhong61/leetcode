package com.lmz.leetcode.practice.contest.old.c301;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

/**
 * https://leetcode.cn/problems/move-pieces-to-obtain-a-string/solutions/1658923/nao-jin-ji-zhuan-wan-pythonjavacgo-by-en-9sqt/
 */
public class CanChange6114 {
    /**
     根据相对位置分析，要想start能变成target，需要满足以下三个条件：

     1 去除下划线之后，两个串应该是相等的；
     2 start中的L与target中的L是一一对应的，而L不能向右移动，所以target中第i个L绝对不能在start中第i个L的右边；
     3 start中的R与target中的R是一一对应的，而R不能向左移动，所以target中第i个R绝对不能在start中第i个R的左边。

     */
    /**
     思路简单：
     两遍扫描，第一次扫描得到字符串start与target的下标不是'_'的下标数组，
     第二遍直接扫描得到的下标数组：有以下三种情况
     1.如果字符不想等，直接返回false
     2.字符相等且是'L'，只需判断start的下标是否小于target的下标
     3.字符相等且是'R'，只需判断start的下标是否大于target的下标
     */
    public boolean canChange(String start, String target) {
        List<Integer>list1=getList(start);
        List<Integer>list2=getList(target);
        if(list1.size()!=list2.size()){
            return false;
        }
        for(int i=0;i<list1.size();i++){
            int ind1=list1.get(i);
            int ind2=list2.get(i);
            char ch1=start.charAt(ind1);
            char ch2=target.charAt(ind2);
            if(ch1!=ch2){
                return false;
            }else{
                if(ch1=='L'){
                    if(ind1<ind2){
                        return false;
                    }
                }else{
                    if(ind1>ind2){
                        return false;
                    }
                }
            }
        }
        return true;
    }
    public List<Integer> getList(String s){
        List<Integer>res=new ArrayList<>();
        for(int i=0;i<s.length();i++){
            if(s.charAt(i)!='_'){
                res.add(i);
            }
        }
        return res;
    }


    private static void testCase(CanChange6114 canChange6114, String start, String target, boolean b) {
        System.out.println(canChange6114.canChange(start, target));
        boolean result = canChange6114.canChange(start, target) == b;
        System.out.println(String.valueOf(result).toUpperCase(Locale.ROOT));
        if(!result){
            System.out.println(start);
            System.out.println(target);
        }
    }
}
