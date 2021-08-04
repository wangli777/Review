package com.wangli.review.leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;

/**
 * @author: bg395819 WangLi
 * @date: 20/12/8 11:12
 * @description:
 * Given s = "leetcode", return "leotcede".
 */
public class ReverseVowelsOfString {
    private final static int MAX_PRINT_LIMIT = 10;


    public static final HashSet<Character> vowels = new HashSet<>(
            Arrays.asList('a', 'e', 'i', 'o', 'u','A', 'E', 'I', 'O', 'U'));

    public static void main(String[] args) {
        String s = "leetcode";
//        System.out.println(reverseVowel(s));


        List<String> orders = Arrays.asList(
                "1","2","3","4","5",
                "6","7","8","9","10",
                "11","12","13","14","15",
                "16","17","18","19","20",
                "21","22","23");
        int i = 0;
        List<String> targetList = getOrders(orders, i);
        while (targetList != null && targetList.size() > 0) {
            targetList.stream().map(e->e.concat(",")).forEach(System.out::print);
            System.out.println("");
            System.out.println("=============");
            i = i + MAX_PRINT_LIMIT;
            targetList = getOrders(orders, i);
            if (targetList == null || targetList.isEmpty()) {
                break;
            }
        }
    }


    private static List<String> getOrders(List<String> orders, int i) {
        if (orders != null && i < orders.size()) {
            List<String> targetList = new ArrayList<String>();
            for (int j = i; j < orders.size(); j++) {
                targetList.add(orders.get(j));
                if (targetList.size() == MAX_PRINT_LIMIT) {
                    return targetList;
                }
            }
            return targetList;
        }
        return null;
    }

//    public static String reverseVowel(String target) {
//        if (target == null) {
//            return null;
//        }
//
//        char[] chars = target.toCharArray();
//        int i = 0;
//        int j = chars.length - 1;
//        while (i <= j) {
//            if (contains(vowels, chars[i]) && contains(vowels, chars[j])) {
//                char temp = chars[i];
//                chars[i] = chars[j];
//                chars[j] = temp;
//            }
//            i++;
//            j--;
//        }
//        return new String(chars);
//    }

    public static boolean contains(char[] chars, char target) {
        for (char aChar : chars) {
            if (target == aChar) {
                return true;
            }
        }
        return false;
    }

}
