package com.lmz.algorithm.other.medium.old;

import java.util.Deque;
import java.util.LinkedList;

public class ScoreOfParentheses856 {
    public int scoreOfParentheses(String s) {
        //记录当前左括号内得分
        Deque<Integer> scoreStack = new LinkedList<>();
        int sum = 0,score = 0;
        //多添加一层左括号
        scoreStack.push(0);
        for(char c : s.toCharArray()){
            if(c == '('){
                scoreStack.push(0);
            }else{ // ')'
                int nowScore = scoreStack.pop();
                if(nowScore == 0){
                    scoreStack.push(scoreStack.pop() + 1);
                }else{
                    scoreStack.push(scoreStack.pop() + nowScore * 2);
                }
            }
        }
        return scoreStack.pop();
    }
}
