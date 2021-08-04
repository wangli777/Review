package com.wangli.review.sort.demo;

import com.wangli.review.sort.base.Sort;

/**
 * @author: bg395819 WangLi
 * @date: 20/12/7 16:39
 * @description:冒泡排序
 * 从左到右不断交换相邻逆序的元素，在一轮的循环之后，可以让未排序的最大元素上浮到右侧。
 * 在一轮循环中，如果没有发生交换，那么说明数组已经是有序的，此时可以直接退出。
 */
public class Bubble<T extends Comparable<T>> extends Sort<T> {

    @Override
    public void sort(T[] nums) {
        boolean isSorted = false;
        for (int i = 0; i < nums.length - 1 && !isSorted; i++) {
            isSorted = true;
            for (int j = 0; j < nums.length - 1 - i; j++) {
                if (less(nums[j + 1], nums[j])) {
                    isSorted = false;
                    swap(nums, j + 1, j);
                }
            }
        }
    }
}
