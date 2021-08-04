package com.wangli.review.leetcode;

/**
 * @author bg395819
 * @date 21/4/29 15:34
 * @description 215. 数组中的第K个最大元素
 * 在未排序的数组中找到第 k 个最大的元素。请注意，你需要找的是数组排序后的第 k 个最大的元素，而不是第 k 个不同的元素。
 * <p>
 * 示例 1:
 * <p>
 * 输入: [3,2,1,5,6,4] 和 k = 2
 * 输出: 5
 * 示例 2:
 * <p>
 * 输入: [3,2,3,1,2,4,5,5,6] 和 k = 4
 * 输出: 4
 * 说明:
 * <p>
 * 你可以假设 k 总是有效的，且 1 ≤ k ≤ 数组的长度。
 */
public class LeetCode215 {

}

class Solution {
    public int findKthLargest(int[] nums, int k) {
        this.bubbleSort(nums);
        return nums[k - 1];
    }

    private void bubbleSort(int[] nums) {
        boolean swap = true;
        for (int i = 0; i < nums.length && swap; i++) {
            //如果有一轮排序没有发生过交换，说明已经排好序了，不需要再进行下一轮排序了。
            swap = false;
            for (int j = 0; j < nums.length - 1 - i; j++) {
                if (nums[j] < nums[j + 1]) {
                    int temp = nums[j];
                    nums[j] = nums[j + 1];
                    nums[j + 1] = temp;
                    //发生了交换
                    swap = true;
                }
            }
        }
    }
}
