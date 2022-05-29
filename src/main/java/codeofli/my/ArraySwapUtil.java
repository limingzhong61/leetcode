package codeofli.my;

public class ArraySwapUtil {

    public  void  swap(int[][] matrix,int i,int j,int a,int b){
        int temp = matrix[i][j];
        matrix[i][j] = matrix[a][b];
        matrix[a][b] = temp;
    }
}
