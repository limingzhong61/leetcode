package codeofli.my.strings;

public class KMP {
    public int index(String source, String pattern) {
        if(pattern.length() == 0){
            return 0;
        }
        int[] next = getNext(pattern);
        int j = 0;
        char[] hayChars = source.toCharArray();
        char[] needleChars = pattern.toCharArray();
        for (int i = 0; i < source.length(); ) {
            if (hayChars[i] != needleChars[j]) {
                j = next[j];
                if(j ==  -1){ //最初位置j匹配不成功，下一个j位置应该是0，且i会移动到下一位
                    j = 0;
                    i++;
                }
                continue;
            }
            j++;
            i++;
            if (j == next.length) {
                return i - next.length;
            }
        }
        return -1;
    }

    public int[] getNext(String pattern) {
        return getNext(pattern.toCharArray());
    }

    public int[] getNext(char[] pattern) {
        int[] next = new int[pattern.length];
        next[0] = -1;
        for (int i = 1; i < pattern.length; i++) {
            int nextJ = next[i - 1];
            while (nextJ != -1 && pattern[i - 1] != pattern[nextJ]) { //找到最小公共前缀
                nextJ = next[nextJ];
            }
            if (nextJ != -1) { //两者相等，此时next[i-1] == nextJ, 等价于chars[i-1] == chars[nextJ]
                next[i] = nextJ + 1;
            } else { //nextJ = -1，则表示没有公共前后缀
                next[i] = 0;
            }
        }
        return next;
    }
}
