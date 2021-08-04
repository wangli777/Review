package com.wangli.review.leetcode;

import java.util.Arrays;

/**
 * @author bg395819
 * @date 21/4/1 16:45
 * @description 在未排序的数组中找到第 k 个最大的元素。请注意，你需要找的是数组排序后的第 k 个最大的元素，而不是第 k 个不同的元素。
 * <p>
 * 示例 1:
 * <p>
 * 输入: [3,2,1,5,6,4] 和 k = 2
 * 输出: 5
 * 示例 2:
 * <p>
 * 输入: [3,2,3,1,2,4,5,5,6] 和 k = 4
 * 输出: 4
 * 说明:
 * <p>
 * 你可以假设 k 总是有效的，且 1 ≤ k ≤ 数组的长度。
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/kth-largest-element-in-an-array
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class FindKthLargest {
    public static int findKthLargest(int[] nums, int k) {
//        selectSort(nums);
        bubbleSort(nums);
        System.out.println(Arrays.toString(nums));
        return nums[k - 1];
    }

    /**
     * 选择排序
     *
     * @param nums
     */
    public static void selectSort(int[] nums) {
        for (int i = 0; i < nums.length - 1; i++) {
            int min = i;
            for (int j = i + 1; j < nums.length; j++) {
                if (nums[min] < nums[j]) {
                    min = j;
                }
            }

            if (min != i) {
                int temp = nums[min];
                nums[min] = nums[i];
                nums[i] = temp;
            }
        }
    }

    public static void bubbleSort(int[] nums) {
        //标志位 是否发生交换
        boolean swap = true;
        for (int i = 0; i < nums.length && swap; i++) {
            //如果没发生交换，则依旧为false，下次就会跳出循环
            swap = false;
            for (int j = 0; j < nums.length - 1 - i; j++) {
                if (nums[j] > nums[j + 1]) {
                    int temp = nums[j];
                    nums[j] = nums[j + 1];
                    nums[j + 1] = temp;
                    //发生交换，则变为true,下次继续判断
                    swap = true;
                }
            }
        }
    }

    public static void main(String[] args) {
//        int[] nums = new int[]{3,2,3,1,2,4,5,5,6};
//        int[] nums1 = new int[]{3,2,3,1,2,4,5,5,6};
//        selectSort(nums);
//        bubbleSort(nums1);
//        System.out.println(Arrays.toString(nums));
//        System.out.println(Arrays.toString(nums1));
        int[] nums = new int[]{3, 2, 3, 1, 2, 4, 5, 5, 6};

        System.out.println(findKthLargest(nums, 4));

        int[] nums2 = new int[]{3, 2, 1, 5, 6, 4};
        System.out.println(findKthLargest(nums2, 2));
    }
}
