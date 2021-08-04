package com.wangli.review.multiThread;

import java.util.concurrent.TimeUnit;

/**
 * @author: bg395819 WangLi
 * @date: 21/1/12 10:51
 * @description: 多线程模拟龟兔赛跑
 */
public class Demo01_Race implements Runnable {

    private static String winner;
    @Override
    public void run() {
        for (int i = 1; i <= 100; i++) {
            //模拟兔子睡觉
            if (Thread.currentThread().getName().equals("兔子") && i % 10 == 0) {
                try {
                    TimeUnit.MICROSECONDS.sleep(10);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }

            }

            //判断比赛是否结束
            boolean hasWinner = hasWinner(i);
            if (hasWinner) {
                break;
            }

            System.out.println(Thread.currentThread().getName() + "跑了" + i + "步");

        }
    }

    private boolean hasWinner(int i) {

        if (winner != null) {
            return true;
        }
        if (i >= 100) {
            winner = Thread.currentThread().getName();
            System.out.println("Winner is " + winner);
            return true;
        }

        return false;

    }

    public static void main(String[] args) {
        Demo01_Race race = new Demo01_Race();
        new Thread(race,"兔子").start();
        new Thread(race,"乌龟").start();
    }
}
