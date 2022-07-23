package codeofli.leetcode.graph_parse_ds.simulation;

import codeofli.my.leetcode.StringTransformUtil;

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
                StringTransformUtil.toIntArray("[1,2,3,4,5]"), StringTransformUtil.toIntArray("[4,5,3,2,1]")));

        System.out.println(validateStackSequences.validateStackSequences(
                StringTransformUtil.toIntArray("[1,2,3,4,5]"), StringTransformUtil.toIntArray(" [4,3,5,1,2]")));
    }
}
