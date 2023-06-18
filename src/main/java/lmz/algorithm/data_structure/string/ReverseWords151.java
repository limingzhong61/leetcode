package lmz.algorithm.data_structure.string;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class ReverseWords151 {
    /**
     * my:利用split函数
     * @param s
     * @return
     */
    public String reverseWords(String s) {
        String trim = s.trim();
        List<String> list = Arrays.asList(trim.split(" +"));
        Collections.reverse(list);
        return String.join(" ",list);
    }

    public static void main(String[] args) {
        ReverseWords151 reverseWords151 = new ReverseWords151();
        System.out.println(reverseWords151.reverseWords("the sky is blue"));
        System.out.println(reverseWords151.reverseWords("  hello world  "));
        System.out.println(reverseWords151.reverseWords("  hello world  ").equals("world hello"));
    }

}
