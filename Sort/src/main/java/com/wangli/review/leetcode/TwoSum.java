package com.wangli.review.leetcode;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * @author: bg395819 WangLi
 * @date: 20/12/8 10:51
 * @description: 题目描述：在有序数组中找出两个数，使它们的和为 target。
 * Input: numbers={2, 7, 11, 15}, target=9
 * Output: index1=1, index2=2
 */
public class TwoSum {

    public static void main(String[] args) {
        int[] arr = new int[]{2, 7, 11, 15};
        int[] ints = twoSum(arr, 26);
        int[] ints2 = twoSum2(arr, 26);
        assert ints != null;
        Arrays.stream(ints).forEach(System.out::println);
        Arrays.stream(ints2).forEach(System.out::println);
    }

    public static int[] twoSum(int[] arr, int target) {
        int i = 0;
        int j = arr.length - 1;
        while (i < j) {
            int sum = arr[i] + arr[j];
            if (sum == target) {
                return new int[]{i + 1, j + 1};
            } else if (sum > target) {
                j--;
            } else {
                i++;
            }
        }
        return null;
    }

    /**
     * 使用hash
     *
     * @param arr
     * @param target
     * @return
     */
    public static int[] twoSum2(int[] arr, int target) {
        Map<Integer, Integer> map = new HashMap(arr.length);
        for (int i = 0; i < arr.length; i++) {
            int temp = target - arr[i];
            if (map.containsKey(temp)) {
                return new int[]{map.get(temp) + 1, i + 1};
            }
            map.put(arr[i], i);
        }
        return null;
    }
}
