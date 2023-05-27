package lmz.algorithm.data_structure.array_and_strings.summary;

public class ReverseWords557 {
    /**
     * 自己实现
     */
    public String reverseWords(String s) {
        char[] chars = s.toCharArray();
        for (int i = 0; i < chars.length; i++) {
            int j = i;
            while (j < chars.length && chars[j] != ' ') {
                j++;
            }
            int temp = j;
            j--;
            for(; i < j; i++ ,j--){
                char t = chars[i];
                chars[i] = chars[j];
                chars[j] = t;
            }
            i = temp;
        }
        return String.valueOf(chars);
    }

    /**
     * 使用api
     */
    public String reverseWords1(String s) {
        //题目说明只有一个空格
        String[] strs = s.split(" ");
        StringBuffer buffer = new StringBuffer();
        for (int i = 0; i < strs.length; i++) {
            buffer.append(new StringBuffer(strs[i]).reverse().toString());
            buffer.append(" ");
        }
        return buffer.toString().trim();
    }

    public static void main(String[] args) {
        ReverseWords557 reverseWords557 = new ReverseWords557();
        System.out.println(reverseWords557.reverseWords("Let's take LeetCode contest"));
        System.out.println(reverseWords557.reverseWords("Let's take LeetCode contest").equals("s'teL ekat edoCteeL tsetnoc"));
        System.out.println(reverseWords557.reverseWords("God Ding"));
        System.out.println(reverseWords557.reverseWords("God Ding").equals("doG gniD"));
    }
}
