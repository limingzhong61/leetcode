package codeofli.my.useful;

public class ArraysUtil {

    public static void reverse(int[] a) {
        for (int i = 0, j = a.length - 1; i < j; i++, j--) {
            int temp = a[i];    //引入中间变量
            a[i] = a[j];
            a[j] = temp;
        }
    }

    /**
     * [start,end]内数组元素交换
     *官方api惯例：将数组置为第一个参数
     * @param a
     * @param start
     * @param end
     *
     */
    public static void reverse(int[] a, int start, int end) {
        for (; start < end; start++, end--) {
            int temp = a[start];    //引入中间变量
            a[start] = a[end];
            a[end] = temp;
        }
    }
}
