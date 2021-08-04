package com.wangli.review.leetcode;

import java.util.HashMap;
import java.util.Map;

/**
 * @author bg395819
 * @date 21/4/29 16:40
 * @description 3. 无重复字符的最长子串
 * 给定一个字符串，请你找出其中不含有重复字符的 最长子串 的长度。
 * 示例 1:
 * 输入: s = "abcabcbb"
 * 输出: 3
 * 解释: 因为无重复字符的最长子串是 "abc"，所以其长度为 3。
 * <p>
 * 示例 2:
 * 输入: s = "bbbbb"
 * 输出: 1
 * 解释: 因为无重复字符的最长子串是 "b"，所以其长度为 1。
 * <p>
 * 示例 3:
 * 输入: s = "pwwkew"
 * 输出: 3
 * 解释: 因为无重复字符的最长子串是 "wke"，所以其长度为 3。
 * 请注意，你的答案必须是 子串 的长度，"pwke" 是一个子序列，不是子串。
 * <p>
 * 示例 4:
 * 输入: s = ""
 * 输出: 0
 * <p>
 * 提示：
 * 0 <= s.length <= 5 * 104
 * s 由英文字母、数字、符号和空格组成
 */
public class LeetCode3 {
    public static void main(String[] args) {
        LeetCode3 leetCode3 = new LeetCode3();
        int length = leetCode3.lengthOfLongestSubstring("abcbb");
        System.out.println(length);
    }

    public int lengthOfLongestSubstring(String s) {
        int max = 0;
        Map<Character, Integer> map = new HashMap<>();
        int head = 0;
        for (int tail = 0; tail < s.length(); tail++) {

            char tailChar = s.charAt(tail);
            //尾指针后移，若遇见已经存在的字符，则将头指针移到该字符的后面
            if (map.containsKey(tailChar)) {
                //头指针后移,必须取两者最大值才能保证后移，不然可能导致头指针往前移
                head = Math.max(map.get(tailChar), head);
            }
            max = Math.max(max, tail - head + 1);
            //map中总是存放每一个字符最新出现的位置，value存的是当前下标+1，因为需要将头指针移到该字符后一位
            map.put(tailChar, tail + 1);

        }
        return max;
    }


    public int lengthOfLongestSubstring2(String s) {
        int max = 0;
        Map<Character, Integer> map = new HashMap<>();
        for (int head = 0, tail = 0; tail < s.length(); tail++) {
            char current = s.charAt(tail);
            if (map.containsKey(current)) {
                head = Math.max(head, map.get(current));
            }
            max = Math.max(max, tail - head + 1);
            map.put(current, tail + 1);

        }
        return max;
    }
}
