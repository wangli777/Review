package com.wangli.review.sort.demo;

import java.util.concurrent.CountDownLatch;

/**
 * @author WangLi
 * @date 2021/4/24 19:04
 * @description 现在有这样一个场景，假设一个自习室里有7个人，其中有一个是班长，
 * 班长的主要职责就是在其它6个同学走了后，关灯，锁教室门，然后走人，
 * 因此班长是需要最后一个走的，那么有什么方法能够控制班长这个线程是最后一个执行，而其它线程是随机执行的
 */
public class CountDownLatchDemo {
    public static void main(String[] args) throws InterruptedException {
        // 计数器
        CountDownLatch latch = new CountDownLatch(6);
        for (int i = 0; i < 6; i++) {
            new Thread(() -> {
                System.out.println(Thread.currentThread().getName() + "离开了教室");
                latch.countDown();
            }, String.valueOf(i)).start();
        }
        latch.await();
        System.out.println(Thread.currentThread().getName() + "关灯，并离开了教室");
    }
}
