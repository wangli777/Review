package com.wangli.review.leetcode;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * @author bg395819
 * @date 21/4/29 15:46
 * @description 1. 两数之和
 * 给定一个整数数组 nums 和一个整数目标值 target，请你在该数组中找出 和为目标值 的那 两个 整数，并返回它们的数组下标。
 * 你可以假设每种输入只会对应一个答案。但是，数组中同一个元素在答案里不能重复出现。
 * 你可以按任意顺序返回答案。
 * 示例 1：
 * 输入：nums = [2,7,11,15], target = 9
 * 输出：[0,1]
 * 解释：因为 nums[0] + nums[1] == 9 ，返回 [0, 1] 。
 * 示例 2：
 * 输入：nums = [3,2,4], target = 6
 * 输出：[1,2]
 * 示例 3：
 * 输入：nums = [3,3], target = 6
 * 输出：[0,1]
 * <p>
 * 提示：
 * 2 <= nums.length <= 103
 * -109 <= nums[i] <= 109
 * -109 <= target <= 109
 * 只会存在一个有效答案
 */
public class LeetCode1 {

    public static void main(String[] args) {
        LeetCode1 code1 = new LeetCode1();
        int[] ints1 = {2, 11, 7, 15};
//        code1.bubbleSort(ints1);
        int[] ints = code1.twoSum(ints1, 55);
        System.out.println(Arrays.toString(ints));
    }

    public int[] twoSum(int[] nums, int target) {
        int n = nums.length;
        for (int i = 0; i < n; ++i) {
            for (int j = i + 1; j < n; ++j) {
                if (nums[i] + nums[j] == target) {
                    return new int[]{i, j};
                }
            }
        }
        return new int[0];
    }


    public int[] twoSum2(int[] nums, int target) {
        Map<Integer, Integer> map = new HashMap();
        for (int i = 0; i < nums.length; i++) {
            int ele = target - nums[i];
            if (map.containsKey(ele)) {
                return new int[]{map.get(ele), i};
            }
            map.put(nums[i], i);
        }
        return null;
    }

    private void bubbleSort(int[] nums) {
        boolean swap = true;
        for (int i = 0; i < nums.length && swap; i++) {
            //如果有一轮排序没有发生过交换，说明已经排好序了，不需要再进行下一轮排序了。
            swap = false;
            for (int j = 0; j < nums.length - 1 - i; j++) {
                if (nums[j] > nums[j + 1]) {
                    int temp = nums[j];
                    nums[j] = nums[j + 1];
                    nums[j + 1] = temp;
                    //发生了交换
                    swap = true;
                }
            }
        }

    }

    //双指针
    public int[] twoSum1(int[] nums, int target) {
        bubbleSort(nums);
        int head = 0, tail = nums.length - 1;
        while (head < tail) {
            int sum = nums[head] + nums[tail];
            if (sum == target) {
                return new int[]{head, tail};
            } else if (sum < target) {
                head++;
            } else {
                tail--;
            }
        }
        return null;
    }
}
