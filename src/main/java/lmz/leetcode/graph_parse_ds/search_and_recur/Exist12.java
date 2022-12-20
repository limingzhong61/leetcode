package lmz.leetcode.graph_parse_ds.search_and_recur;


import java.util.Locale;

public class Exist12 {
    /**
     * 思路：暴力搜索
     * 单词必须按照字母顺序，通过相邻的单元格内的字母构成，其中“相邻”单元格是那些水平相邻或垂直相邻的单元格。
     */
    //移动数组
    int next[][] = new int[][]{
            {-1, 0}, {0, 1}, {1, 0}, {0, -1}
    };

    public boolean exist(char[][] board, String word) {
        int m = board.length,n = board[0].length;
        boolean[][] mark = new boolean[m][n];

        //每个位置都能作为起点
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (search(i, j, 0, board, word,mark)) {
                    return true;
                }
            }
        }
        return false;
    }

    private boolean search(int i, int j, int k, char[][] board, String word,boolean[][] mark) {
        //越界，是否已经被访问，匹配失败
        if (i >= board.length || i < 0 || j < 0 || j >= board[0].length ||
                mark[i][j] || board[i][j] != word.charAt(k)) {
            return false;
        }
        //匹配成功
        if (k == word.length() - 1) {
            return true;
        }
        //标记已经被访问
        mark[i][j] = true;
        boolean result = false;
        for (int a = 0; a < next.length; a++) {
            int nextI = i + next[a][0];
            int nextJ = j + next[a][1];
            result = search(nextI, nextJ, k + 1, board, word,mark);
            if (result) {
                break;
            }
        }
        mark[i][j] = false;
        return result;
    }

    public static void main(String[] args) {
        Exist12 exist12 = new Exist12();
        System.out.println(exist12.exist(new char[][]{{'A', 'B', 'C', 'E'}, {'S', 'F', 'C', 'S'}, {'A', 'D', 'E', 'E'}}, "ABCCED"));
        System.out.println(String.valueOf(exist12.exist(new char[][]{{'A', 'B', 'C', 'E'}, {'S', 'F', 'C', 'S'}, {'A', 'D', 'E', 'E'}}, "ABCCED") == true).toUpperCase(Locale.ROOT) );
        System.out.println(exist12.exist(new char[][]{{'A', 'B', 'C', 'E'}, {'S', 'F', 'C', 'S'}, {'A', 'D', 'E', 'E'}}, "SEE"));
        System.out.println(String.valueOf(exist12.exist(new char[][]{{'A', 'B', 'C', 'E'}, {'S', 'F', 'C', 'S'}, {'A', 'D', 'E', 'E'}}, "SEE")
                == true).toUpperCase(Locale.ROOT) );
        System.out.println(exist12.exist(new char[][]{{'A', 'B', 'C', 'E'}, {'S', 'F', 'C', 'S'}, {'A', 'D', 'E', 'E'}}, "ABCB"));
        System.out.println(String.valueOf(exist12.exist(new char[][]{{'A', 'B', 'C', 'E'}, {'S', 'F', 'C', 'S'}, {'A', 'D', 'E', 'E'}}, "ABCB")
                == false).toUpperCase(Locale.ROOT) );
        System.out.println(exist12.exist(new char[][]{{'a'}}, "a"));
        System.out.println(String.valueOf(exist12.exist(new char[][]{{'a'}}, "a")
                == true).toUpperCase(Locale.ROOT) );
        System.out.println(exist12.exist(new char[][]{{'A', 'B', 'C', 'E'}, {'S', 'F', 'E', 'S'}, {'A', 'D', 'E', 'E'}}, "ABCEFSADEESE"));
        System.out.println(String.valueOf(exist12.exist(new char[][]{{'A', 'B', 'C', 'E'}, {'S', 'F', 'E', 'S'}, {'A', 'D', 'E', 'E'}}, "ABCEFSADEESE")
                == true).toUpperCase(Locale.ROOT) );
    }
}
