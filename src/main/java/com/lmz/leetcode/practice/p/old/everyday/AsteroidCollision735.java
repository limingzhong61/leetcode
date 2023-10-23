package com.lmz.leetcode.practice.p.old.everyday;

import com.lmz.algorithm_learning.leetcode.TransformUtil;

import java.util.Arrays;
import java.util.Deque;
import java.util.LinkedList;

public class AsteroidCollision735 {
    /**
     * leetcode: 栈-模拟
     * 用栈 st 模拟行星碰撞，从左往右遍历行星数组 asteroids，当我们遍历到行星 aster 时，使用变量 alive 记录行星 aster 是否还存在（即未爆炸）。
     * 当行星 aster 存在且 aster<0，栈顶元素非空且大于 0 时，说明两个行星相互向对方移动：
     * 如果栈顶元素大于等于 −aster，则行星 aster 发生爆炸，将 alive 置为 false；如果栈顶元素小于等于 −aster，则栈顶元素表示的行星发生爆炸，执行出栈操作.
     * 重复以上判断直到不满足条件，如果最后 alive 为真，说明行星 aster 不会爆炸，则将 aster 入栈。
     */
    public int[] asteroidCollision(int[] asteroids) {
        Deque<Integer> stack = new LinkedList<>();
        for (int aster : asteroids) {
            boolean alive = true;
            while (alive && aster < 0 && !stack.isEmpty() && stack.peek() > 0) {
                if(stack.peek() < -aster){ // 栈顶行星爆炸
                    stack.pop();
                }else if(stack.peek() > -aster){
                    alive = false;
                }else { // ==
                    alive = false;
                    stack.pop();
                }
            }
            if (alive) {
                stack.push(aster);
            }
        }
        int[] res = new int[stack.size()];
        int index = stack.size()-1;
        while(!stack.isEmpty()){
            res[index--] = stack.pop();
        }
        return res;
    }

    /**
     * 双指针:模拟
     * plus:找到向右移动的一个 ,因为往右走，故应该找到最右的一个
     * minus:找到向左移动的一个
     * minus > plus 才会相撞
     */
    public int[] asteroidCollision2(int[] asteroids) {
        int len = asteroids.length;
        int plus = -1, minus = -1;
        for (int i = 0; i < len; i++) {
            if (asteroids[i] > 0) {
                if (i + 1 < len && asteroids[i + 1] > 0) {
                    continue;
                }
                plus = i;
                break;
            }
        }
        for (int i = 0; i < len; i++) {
            if (asteroids[i] < 0) {
                minus = i;
                break;
            }
        }
        if (plus == -1 || minus == -1) { //只有正数或负数
            return asteroids;
        }
        int collisionCnt = 0;
        while (plus < len && minus < len) {
            if (minus > plus) {// 会相撞；
                if (-asteroids[minus] > asteroids[plus]) {
                    asteroids[plus] = 0; // 0表示毁灭；
                    collisionCnt++;
                    //先往回找--- 找到一个负号，说明之前的都是负号了
                    while (plus > 0 && asteroids[plus] == 0) { // find-next;
                        plus--;
                    }
                    if (asteroids[plus] > 0) { //找到了
                        continue;
                    }
                    //说明minus之前没有正号了，此时[minus,.... plus],需要找到最右plus
                    plus = minus + 1;
                    while (plus < len && asteroids[plus] <= 0) { // find-next;
                        plus++;
                    }
                    while (plus + 1 < len && asteroids[plus + 1] > 0) { // 找到最右plus
                        plus++;
                    }
                } else if (-asteroids[minus] < asteroids[plus]) {
                    asteroids[minus] = 0;
                    collisionCnt++;
                    while (minus < len && asteroids[minus] >= 0) { // find-next;
                        minus++;
                    }
                    int tempPlus = plus + 1;
                    while (tempPlus < minus - 1 && asteroids[tempPlus] >= 0) { // find-next;
                        tempPlus++;
                    }
                    //向右找到新的
                    if (asteroids[tempPlus] > 0) {
                        plus = tempPlus;
                    }
                } else { // ==
                    asteroids[plus] = 0;
                    asteroids[minus] = 0;
                    collisionCnt += 2;
                    while (minus < len && asteroids[minus] >= 0) { // find-next;
                        plus = minus;
                        minus++;
                    }
                    //plus 向往右找，如果能先于minus找到，则为找到，否则往回找
                    //先右找
                    if (asteroids[plus] > 0) { //找到了
                        continue;
                    }
                    //往回找
                    while (plus > 0 && asteroids[plus] <= 0) { // find-next;
                        plus--;
                    }
                    if (plus == 0 && asteroids[0] <= 0) {// 没找到
                        plus = minus + 1;
                    }
                }
            } else { //minus < plus
                minus = plus + 1; //负数必须在正数左侧才会碰撞
                while (minus < len && asteroids[minus] >= 0) { // find-next;
                    minus++;
                }
                if (minus == len - 1 && asteroids[minus] > 0) { //直到最后一个都没找到minus
                    break;
                }
            }
        }
        int[] res = new int[len - collisionCnt];
        int idx = 0;
        for (int item : asteroids) {
            if (item != 0) {
                res[idx++] = item;
            }
        }
        return res;
    }

    public static void main(String[] args) {
        AsteroidCollision735 asteroidCollision735 = new AsteroidCollision735();
        //testCase(asteroidCollision735, "[5,10,-5]", " [5,10]");
        testCase(asteroidCollision735, "[8,-8]", "[]");
        testCase(asteroidCollision735, "[10,2,-5]", "[10]");
        testCase(asteroidCollision735, "[10,2,-5,5,8,-8,10,-5]", "[10, 5, 10]");
        testCase(asteroidCollision735, "[-2,-1,1,2]", "[-2, -1, 1, 2]");
        testCase(asteroidCollision735, "[-2,-2,-2,-2]", "[-2,-2,-2,-2]");
        testCase(asteroidCollision735, "[-2,-2,1,-2]", "[-2,-2,-2]");
        testCase(asteroidCollision735, "[1,1,-1,-2]", "[-2]");
        testCase(asteroidCollision735, "[-2,1,-1,-2]", "[-2,-2]");
        testCase(asteroidCollision735, "[-9,5,-7,5,2,-5,-5,8,3,10]", "[-9,-7,-5,8,3,10]");
        testCase(asteroidCollision735, "[64,-45,-100,-93,-52,-88,27,-19,-96,28,24,66,-4,76,52,-4,100,95,44,-69,-48,51,87,77,49,-92,-85,8,9,76,22,76,-36,-91,-58,-77,-52,67,19,-43,-24,86,-91,-1,83,-60,-53,40,-68,25,-42,6,91,-95,10,-42,-79,16,35,-30,-49,-100,35,100,-96,98,12,-16,-50,85,9,-52," +
                        "-91,-3,-84,-26,-26,-34,-62,64,-70,49,-28,-61,-85,-62,-68,30,72,52,-14,81,-61,-43,-65,-40,-5,64,-58,16]",
                "[-100,-93,-52,-88,-96,28,24,66,76,52,35,100,98,30,72,52,81,64,16]");
        testCase(asteroidCollision735, "[-1,43,-19,-55,38,-44,-68,-10,52,14,-47,16,-17,90,22,-47,71,88,13,-96,-56,17,21,61,26,-3,-3,24,60,-24,12,-55,-18,-11,1,63,90,94,-95,54,-84,-58,77,93,67,-22,91,-25,-1,-12,57,-59,47,-42,-81,-21,-71,-89,-11," +
                        "77,83,72,35,-68,11,38,50,48,68,12,43,58,-32,-73,-41,38,82,66,-1,64,8,21,31,-99,-46,46,6,-32,-12,19,99,-14," +
                        "18,88,-48,75,-88,-65,66,-66]",
                "[-1,-55,-44,-68,-10,-96,-56,-95,-84,-58,-99,-46,46,19,99]");
    }

    private static void testCase(AsteroidCollision735 asteroidCollision735, String s, String s2) {
        System.out.println(Arrays.toString(asteroidCollision735.asteroidCollision(TransformUtil.toIntArray(s))));
        System.out.println(Arrays.equals(asteroidCollision735.asteroidCollision(TransformUtil.toIntArray(s)),
                TransformUtil.toIntArray(s2)));
    }
}
