package codeofli.my.leetcode;

import java.util.stream.Stream;

public class TransformString {

    public static String ArrayToJavaForm(String original) {
        return original.replaceAll("\\[", "{").
                replaceAll("\\]", "}").
                replaceAll("\"", "'");
    }

    public static int[] toIntArray(String original) {
        String s = original.replaceAll("\\[", "").
                replaceAll("\\]", "").
                replaceAll(" ", "");
        if ("".equals(s)) {
            return new int[0];
        }
        String[] split = s.split(",");
        int[] nums = new int[split.length];
        for (int i = 0; i < split.length; i++) {
            nums[i] = Integer.parseInt(split[i]);
        }
        return nums;
    }

    public static void main(String[] args) {
        System.out.println(ArrayToJavaForm("[[\"A\",\"B\",\"C\",\"E\"],[\"S\",\"F\",\"E\",\"S\"],[\"A\",\"D\",\"E\",\"E\"]]"));
    }
}
