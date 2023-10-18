package com.lmz.algorithm_learning.sort.heap_sort;

import java.lang.reflect.Array;
import java.util.Arrays;

import static com.lmz.algorithm_learning.util.ArraysUtil.swap;

/**
 * @author: limingzhong
 * @create: 2023-10-11 15:40
 *
 * 详见HeapSort.md
 * 定义n个关键字序列L [ 1...n]称为堆，这个堆从1开始
 * 1. L(i)>=L(2i)且L(i)>=L(2i+1)或
 * 2. L(i)<=L(2i)且L(i)<=L(2i+1)(1≤i<Ln/2」)
 */
public class HeapSort {
    /**
     * 建立大根堆的算法
     * @param a 下标从1开始
     * @param len
     * @return
     */
    int[] buildMaxHeap(int a[],int len) {
        //从i=[n/2]～1，反复调整堆
        for (int i = len / 2; i > 0; i--) {
            headAdjust(a, i, len);
        }
        return a;
    }

    /**
     * 函数HeadAdjust将元素k为根的子树进行调整
     *
     * @param a
     * @param k
     */
    private void headAdjust(int[] a, int k, int len) {
        //A[0]暂存子树的根结点
        a[0] = a[k];
        for (int i = 2 * k; i <= len; i *= 2) {
            //取key较大的子结点的下标为i
            if (i < len && a[i] < a[i + 1]) {
                i++;
            }
            if (a[0] >= a[i]) {     //筛选结束
                break;
            } else {
                a[k] = a[i];        //将A[i]调整到双亲结点上
                k = i;              //修改k值,以便继续向下筛选
            }
        }
        a[k] = a[0];            //被筛选结点的值放入最终位置
    }

    int[] headSort(int a[],int len) {
        // 初始建堆
        buildMaxHeap(a,len);
        // n-1 趟的交换和建堆过程
        for (int i = len; i > 1; i--) {
            // 输出堆顶元素(和堆底交换)
            swap(a, i, 1);
            // 调整，把剩余的 i-1 个元素整理成堆
            headAdjust(a, 1, i - 1);
        }
        return a;
    }

    public static void main(String[] args) {
        HeapSort heapSort = new HeapSort();
        //这个堆排序排序的数组下标从1开始
        int[] a = new int[]{0, 3, 4, 2, 5, 6, 7, 9, 1, 22, 1};
        //System.out.println(Arrays.toString(heapSort.buildMaxHeap(a,a.length-1)));
        System.out.println(Arrays.toString(heapSort.headSort(a,a.length-1)));
        //System.out.println(Arrays.equals(heapSort.headSort(a,a.length-1),Arrays.sort(a)));
    }
}
