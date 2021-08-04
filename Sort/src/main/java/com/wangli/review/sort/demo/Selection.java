package com.wangli.review.sort.demo;

import com.wangli.review.sort.base.Sort;

/**
 * @author: bg395819 WangLi
 * @date: 20/12/7 16:15
 * @description: 选择排序：从头到尾遍历，将最小的元素与第一个元素交换位置，以此类推
 */
public class Selection<T extends Comparable<T>> extends Sort<T> {
    @Override
    public void sort(T[] nums) {
        for (int i = 0; i < nums.length - 1; i++) {
            //min记录此次循环中最小元素的下标
            int min = i;
            for (int j = i + 1; j < nums.length; j++) {
                if (less(nums[j], nums[min])) {
                    //min记录此次循环中最小元素的下标
                    min = j;
                }
            }
            //结束循环后将最小元素换到头部
            swap(nums, i, min);
        }
    }
}
