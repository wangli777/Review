package com.wangli.review.multiThread;

/**
 * @author: bg395819 WangLi
 * @date: 21/1/12 18:48
 * @description: 线程停止 ：不推荐使用stop()、destroy()方法
 * 推荐使用一个标志位，让线程自己停下来
 */
public class Demo04_ThreadStop implements Runnable {
    private boolean flag = true;

    @Override
    public void run() {
        int i = 0;
        while (flag) {
            System.out.println(Thread.currentThread().getName() + " is running" + i++);
        }
    }

    public void stop() {
        this.flag = false;
    }

    public static void main(String[] args) {
        Demo04_ThreadStop target = new Demo04_ThreadStop();
        new Thread(target, "t1").start();

        for (int i = 0; i < 1000; i++) {
            System.out.println(Thread.currentThread().getName()+i);
            if (i == 900) {
                target.stop();
                System.out.println("线程该停止了");
            }
        }
    }

}

