package lmz.my.util;

/**
 * grid,格子地图移动
 */
public class GridMapUsage {
    //move code
    {
        //some position
        int i = 0;
        int j = 0;

        //移动数组
        int fourDir[][] = new int[][]{
                {-1, 0}, {0, 1}, {1, 0}, {0, -1}
        };
        for(var dir : fourDir){
            int nextI = i + dir[0];
            int nextJ = j + dir[1];
        }
    }
}
