package com.wangli.review.leetcode;

import java.util.Arrays;

/**
 * @author WangLi
 * @date 2021/4/27 21:09
 * @description 59. 螺旋矩阵 II
 * 给你一个正整数 n ，生成一个包含 1 到 n2 所有元素，且元素按顺时针顺序螺旋排列的 n x n 正方形矩阵 matrix 。
 * 示例 1：
 * 输入：n = 3
 * 输出：[[1,2,3],[8,9,4],[7,6,5]]
 * <p>
 * 示例 2：
 * 输入：n = 1
 * 输出：[[1]]
 */
public class LeetCode59 {
    public static void main(String[] args) {
        int[][] matrix = generateMatrix(3);
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix.length; j++) {
                System.out.println(matrix[i][j]);
            }
        }
        System.out.println(Arrays.deepToString(matrix));
    }
    public static int[][] generateMatrix(int n) {
        int left = 0;
        int top = 0;
        int right = n - 1 ;
        int bottom = n - 1;
        int num = 1;
        int total = n * n;
        int[][] arr = new int[n][n];
        while (num <= total) {
            //从左上往右上
            for (int i = left; i <= right; i++) {
                arr[top][i] = num++;
            }
            //上边界下移
            top++;
            //从右上往右下
            for (int i = top; i <= bottom ; i++) {
                arr[i][right] = num++;
            }
            //右边界左移
            right--;
            //从右下往左下
            for (int i = right; i >= left ; i--) {
                arr[bottom][i] = num++;
            }
            //下边界上移
            bottom--;
            //从左下往左上
            for (int i = bottom; i >= top ; i--) {
                arr[i][left] = num++;
            }
            //左边界右移
            left++;
        }
        return arr;
    }
}
