package lmz.algorithm.other.old.two_pointer;

public class ReverseWords58 {
    /**
     * 双指针
     */
    public String reverseWords(String s) {
        s = s.trim();
        int j = s.length() - 1,i = j;
        StringBuilder sb = new StringBuilder();
        while (i >= 0 ) {
            while(i >= 0 && s.charAt(i) != ' ') i--; // 搜索首个空格
            sb.append(s.substring(i + 1, j + 1) + " "); // 添加单词
            while(i >= 0 && s.charAt(i) == ' ') i--; // 跳过单词间空格
            j = i; // j 指向下个单词的尾字符
        }
        if (sb.toString().equals("")) {
            return sb.toString();
        }
        return sb.toString().trim();
    }

    public String reverseWords1(String s) {
        String[] s1 = s.trim().split(" +");
        StringBuilder sb = new StringBuilder();
        if (s1.length == 0) {
            return null;
        }
        for (int i = s1.length - 1; i >= 0; i--) {
            sb.append(" ").append(s1[i]);
        }
        return sb.substring(1);
    }

    public static void main(String[] args) {
        ReverseWords58 reverseWords58 = new ReverseWords58();
        ////
        System.out.println(reverseWords58.reverseWords("the sky is blue"));
        System.out.println(reverseWords58.reverseWords("the sky is blue").equals("blue is sky the"));

        System.out.println(reverseWords58.reverseWords("  hello world  "));
        System.out.println(reverseWords58.reverseWords("  hello world  ").equals("world hello"));

        System.out.println(reverseWords58.reverseWords("a good   example"));
        System.out.println(reverseWords58.reverseWords("a good   example").equals("example good a"));

        System.out.println(reverseWords58.reverseWords(" "));
        System.out.println(reverseWords58.reverseWords(" ").equals(""));

        System.out.println(reverseWords58.reverseWords("  hello world!  "));
        System.out.println(reverseWords58.reverseWords("  hello world!  ").equals("world! hello"));
    }
}
