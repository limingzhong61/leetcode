package codeofli.leetcode.other.function;

public class CheckStraightLine1232 {
    /**
     * 由斜率公式得
     * (y1-y0)/(x1-x0)=(yi-y0)/(xi-x0)
     * 防止除0，变换成相乘的形式
     * (y1-y0)*(xi-x0)==(x1-x0)*(yi-y0)
     */
    public boolean checkStraightLine(int[][] coordinates) {
    //    2 <= coordinates.length <= 1000
        int x0 = coordinates[0][0],y0 = coordinates[0][1];
        int x1 = coordinates[1][0],y1 = coordinates[1][1];
        for(int i = 2; i < coordinates.length;i++){
            //斜率不一样
            if((coordinates[i][0] - x1)*(y1-y0) != (coordinates[i][1] - y1)*(x1-x0)){
                return false;
            }
        }
        return true; //两点必成直线
    }

}
