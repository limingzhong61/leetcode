package lmz.leetcode.other.medium;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;

public class AsteroidCollisionII037 {

    /**
     * lc
     */
    class Solution {
        public int[] asteroidCollision(int[] asteroids) {
            Deque<Integer> stack = new ArrayDeque<Integer>();
            for (int aster : asteroids) {
                boolean alive = true;
                while (alive && aster < 0 && !stack.isEmpty() && stack.peek() > 0) {
                    alive = stack.peek() < -aster; // aster 是否存在
                    if (stack.peek() <= -aster) {  // 栈顶小行星爆炸
                        stack.pop();
                    }
                }
                if (alive) {
                    stack.push(aster);
                }
            }
            int size = stack.size();
            int[] ans = new int[size];
            for (int i = size - 1; i >= 0; i--) {
                ans[i] = stack.pop();
            }
            return ans;
        }
    }

    public int[] asteroidCollision(int[] asteroids) {
        Deque<Integer> stack = new ArrayDeque<>();
        List<Integer> res = new ArrayList<>();
        for(int i = 0; i < asteroids.length; i++){
            if(asteroids[i] > 0){ // right move
                stack.push(asteroids[i]);
            }else{
                boolean add = true;
                while(!stack.isEmpty()){
                    if(stack.peek() < -asteroids[i]){
                        stack.pop();
                    }else if(stack.peek() == -asteroids[i]){
                        stack.pop();
                        add = false;
                        break;
                    }else{
                        add = false;
                        break;
                    }
                }
                if(add){ // 只剩下了left move
                    stack.add(asteroids[i]);
                }
            }
        }
        int[] ans = new int[stack.size()];
        int idx = ans.length - 1;
        while(!stack.isEmpty()){
            ans[idx--] = stack.pop();
        }

        return ans;
    }
}
