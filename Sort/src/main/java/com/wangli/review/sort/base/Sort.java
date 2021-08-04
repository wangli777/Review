package com.wangli.review.sort.base;

/**
 * @author: bg395819 WangLi
 * @date: 20/12/7 16:09
 * @description:
 */
public abstract class Sort<T extends Comparable<T>> {

    public abstract void sort(T[] nums);

    protected boolean less(T a, T b) {
        return a.compareTo(b) < 0;
    }

    protected void swap(T[] arr, int i, int j) {
        T t = arr[i];
        arr[i] = arr[j];
        arr[j] = t;
    }
}
