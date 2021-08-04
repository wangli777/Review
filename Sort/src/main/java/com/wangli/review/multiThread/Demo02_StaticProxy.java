package com.wangli.review.multiThread;


/**
 * @author: bg395819 WangLi
 * @date: 21/1/12 16:55
 * @description: 静态代理模式实例
 *
 * 静态代理：代理对象和被代理对象都需要实现同一个接口
 * Person类：被代理对象
 * Company类：代理对象
 * 实现的效果为，company对象代理person对象进行结婚
 */
public class Demo02_StaticProxy {

    public static void main(String[] args) {
        new Company(new Person("张三")).marry();
        //上述代码其实就是Runnable创建线程的设计模式
        new Thread(new Demo01_Race(),"兔子").start();
    }

}

interface Marry {
    void marry();
}
class Person implements Marry{

    private String name;

    public Person(String name) {
        this.name = name;
    }

    @Override
    public void marry() {
        System.out.println(name+"高高兴兴结婚");
    }
}

class Company implements Marry {
    private Person person;

    public Company(Person person) {
        this.person = person;
    }

    @Override
    public void marry() {
        System.out.println("结婚前布置婚礼现场");
        person.marry();
        System.out.println("结婚后打扫婚礼现场");
    }
}
