package com.wangli.review.leetcode;

/**
 * @author: bg395819 WangLi
 * @date: 20/12/8 10:59
 * @description:
 * 题目描述：判断一个非负整数是否为两个整数的平方和。
 * Input: 5
 * Output: True
 * Explanation: 1 * 1 + 2 * 2 = 5
 */
public class SumOfSquareNumbers {
    public static void main(String[] args) {
        System.out.println(judgeSquareSum(5));
        System.out.println(judgeSquareSum(4));
        System.out.println(judgeSquareSum(6));
        System.out.println(judgeSquareSum(8));
        System.out.println(judgeSquareSum(9));
        System.out.println(judgeSquareSum(10));
    }

    public static boolean judgeSquareSum(int target) {
        if (target < 0) {
            return false;
        }
        int i = 0;
        int j = (int) Math.sqrt(target);
        while (i <= j) {
            int result = i * i + j * j;
            if (result == target) {
                return true;
            } else if (result < target) {
                i++;
            } else {
                j--;
            }
        }
        return false;
    }
}
