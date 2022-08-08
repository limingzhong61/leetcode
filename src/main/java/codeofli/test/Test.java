package codeofli.test;

import java.util.Arrays;
import java.util.Scanner;

public class Test {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int num;
        System.out.println("input one number:");
        num = sc.nextInt();
        if(fun(num)){
            System.out.println("the number is Palindrome");
        }else{
            System.out.println("the number is not Palindrome");
        }
    }
    public static boolean fun(int num){
        if(num<0)
            return false;
        int rem=0,n=0;
        int qnum=num;
        while(qnum!=0){
            rem=qnum%10;
            n=n*10+rem;
            qnum=qnum/10;
        }
        return n==num;
    }

}
