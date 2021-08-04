package com.wangli.review.demo;

import java.util.concurrent.*;
import java.util.function.Consumer;
import java.util.function.Supplier;

/**
 * @author bg395819
 * @date 21/4/25 15:48
 * @description 单例模式 双重校验锁
 */
public class SingletonDemo {
    private static volatile SingletonDemo instance = null;

    private SingletonDemo() {
        System.out.println(Thread.currentThread().getName() + "线程执行了构造方法");
    }

    public static SingletonDemo getInstance() {
        if (instance == null) {
            synchronized (SingletonDemo.class) {
                if (instance == null) {
                    instance = new SingletonDemo();
                }
            }
        }
        return instance;
    }

    public static void main(String[] args) throws InterruptedException {
//        for (int i = 0; i < 5; i++) {
//            new Thread(() -> {
//                SingletonDemo instance = getInstance();
//                System.out.println(instance);
//            }, String.valueOf(i)).start();
//        }
        //拒绝策略
        /**
         * AbortPolicy：默认，直接抛出RejectedExcutionException异常，阻止系统正常运行
         * DiscardPolicy：直接丢弃任务，不予任何处理也不抛出异常，如果运行任务丢失，这是一种好方案
         * CallerRunsPolicy：该策略既不会抛弃任务，也不会抛出异常，而是将某些任务回退到 调用者线程
         * DiscardOldestPolicy：抛弃队列中等待最久的任务，然后把当前任务加入队列中尝试再次提交当前任务
         */
//        ThreadPoolExecutor.AbortPolicy rejectedHandler = new ThreadPoolExecutor.AbortPolicy();
//        ThreadPoolExecutor.CallerRunsPolicy rejectedHandler = new ThreadPoolExecutor.CallerRunsPolicy();
        ThreadPoolExecutor.DiscardOldestPolicy rejectedHandler = new ThreadPoolExecutor.DiscardOldestPolicy();
//        ThreadPoolExecutor.DiscardPolicy rejectedHandler = new ThreadPoolExecutor.DiscardPolicy();
        ExecutorService executorService = new ThreadPoolExecutor(
                2, 5, 1000, TimeUnit.MILLISECONDS, new LinkedBlockingQueue<>(3), Executors.defaultThreadFactory(), rejectedHandler);
        try {
            for (int i = 0; i < 10; i++) {

                int finalI = i;
                executorService.execute(()->{
                    System.out.println(Thread.currentThread().getName()+"线程正在给用户"+ finalI +"办业务");
                });
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            executorService.shutdown();
        }

        Thread.sleep(Integer.MAX_VALUE);


        System.out.println("======================");
        Supplier supplier = new Supplier() {
            @Override
            public Object get() {
                return "some thing";
            }

        };
        Supplier supplier1 = () -> "some";

        Consumer consumer = new Consumer() {
            @Override
            public void accept(Object o) {
                System.out.println(o);
            }
        };
        Consumer consumer1 = System.out::println;


        System.out.println(supplier.get());
        System.out.println(supplier1.get());
        consumer.accept("consumer");
        consumer1.accept("consumer1");






    }


}
