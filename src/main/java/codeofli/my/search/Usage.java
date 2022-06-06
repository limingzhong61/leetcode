package codeofli.my.search;

public class Usage {
    //move code
    {
        //some position
        int i = 0;
        int j = 0;

        //移动数组
        int next[][] = new int[][]{
                {-1, 0}, {0, 1}, {1, 0}, {0, -1}
        };
        for (int a = 0; a < next.length; a++) {
            int nextI = i + next[a][0];
            int nextJ = j + next[a][1];
            //    do some sth
        }
    }
}
