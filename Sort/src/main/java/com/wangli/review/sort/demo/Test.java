package com.wangli.review.sort.demo;

import java.util.*;

/**
 * @author WangLi
 * @date 2021/4/19 20:05
 * @description
 */
public class Test {
    public static void main(String[] args) {
//        System.out.println(max(9, 7, 2));
//        System.out.println(test(9, 7, 2));
//        List<Object> synchronizedList = Collections.synchronizedList(new ArrayList<>());
//        synchronizedList.add("1");
//        Map<Object, Object> synchronizedMap = Collections.synchronizedMap(new HashMap<>());
//        ConcurrentHashMap<Object, Object> concurrentHashMap = new ConcurrentHashMap<>();
//
//        Lock lock = new ReentrantLock(true);

        List<String> list = new ArrayList<>(10);
        list.add("f");
        list.add(0, "sa");
        list.add(3, "s");
        list.forEach(System.out::println);
//        System.out.println(list.get(2));


    }

    public static int test(int a, int b, int c) {
        return a > b ? (a > c ? a : c) : (b > c ? b : c);
    }

    public static int max(int a, int b, int c) {
        if (a > b) {
            if (a > c) {
                return a;
            }else {
                return c;
            }
        } else {
            if (b > c) {
                return b;
            }else {
                return c;
            }
        }
    }
}
