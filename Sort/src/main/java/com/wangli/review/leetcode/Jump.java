package com.wangli.review.leetcode;

/**
 * @author bg395819
 * @date 21/4/1 14:00
 * @description: 给定一个非负整数数组，你最开始位于第一个下标处，数组中的每个元素代表你当前可以跳跃的最大距离，判断你是否能到达最后一个下标
 * 例如：
 *      输入：[2,3,1,1,4]
 *      输出：true
 *      解释：可以先跳一步，到3处，再跳3步到最后下标处。
 *
 *      输入：[3,2,1,0,4]
 *      输出：false
 *      解释：无论如何最大只能到0处，但此时最大跳跃距离是0，不可能到达最后。
 */
public class Jump {

    public static boolean canJumpFinal1(int[] arr) {
        int max = 0;
        for (int i = 0; i < arr.length-1; i++) {
            max = Math.max(max, i + arr[i]);

            if (max <= i) {
                return false;
            }
        }
        return true;
    }



    public static boolean canJumpFinal(int[] arr) {

        //能到达的最远距离
        int maxJump = 0;
        for (int i = 0; i < arr.length-1; i++) {
            maxJump = Math.max(maxJump, i + arr[i]);

            if (maxJump <= i) {
                return false;
            }
        }

        return true;
    }

    public static void main(String[] args) {
        int[] arr = new int[]{2, 3, 1, 1, 4};
        int[] arr2 = new int[]{3, 2, 1, 0, 4};
        System.out.println(canJumpFinal(arr));
        System.out.println(canJumpFinal(arr2));
    }
}
