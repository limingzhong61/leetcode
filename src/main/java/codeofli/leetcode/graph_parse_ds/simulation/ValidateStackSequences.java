package codeofli.leetcode.graph_parse_ds.simulation;

import codeofli.my.leetcode.TransformUtil;

import java.util.Deque;
import java.util.LinkedList;

public class ValidateStackSequences {
    public boolean validateStackSequences(int[] pushed, int[] popped) {
        Deque<Integer> stack = new LinkedList<>();
        int index = 0;
        for(int i : pushed){
            stack.push(i);
            while (!stack.isEmpty() && stack.peek() == popped[index]){
                stack.pop();
                index++;
            }
        }
        return stack.isEmpty();
    }

    public static void main(String[] args) {
        ValidateStackSequences validateStackSequences = new ValidateStackSequences();

        System.out.println(validateStackSequences.validateStackSequences(
                TransformUtil.toIntArray("[1,2,3,4,5]"), TransformUtil.toIntArray("[4,5,3,2,1]")));

        System.out.println(validateStackSequences.validateStackSequences(
                TransformUtil.toIntArray("[1,2,3,4,5]"), TransformUtil.toIntArray(" [4,3,5,1,2]")));
    }
}
