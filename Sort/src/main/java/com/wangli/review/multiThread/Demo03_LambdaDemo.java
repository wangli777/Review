package com.wangli.review.multiThread;

/**
 * @author: bg395819 WangLi
 * @date: 21/1/12 17:15
 * @description:
 */
public class Demo03_LambdaDemo {
    //方式2 静态内部类
    static class Like2 implements ILike {

        @Override
        public void like() {
            System.out.println("i like lambda 2");
        }
    }

    public static void main(String[] args) {
        ILike like1 = new Like();
        like1.like();

        ILike like2 = new Like2();
        like2.like();

        //方式3 局部内部类
        class Like3 implements ILike {

            @Override
            public void like() {
                System.out.println("i like lambda 3");
            }
        }
        ILike like3 = new Like3();
        like3.like();

        //方式4 匿名内部类
        ILike like4 = new ILike() {
            @Override
            public void like() {
                System.out.println("i like lambda 4");
            }
        };
        like4.like();

        //方式5 Lambda函数式接口
        ILike like5 = ()-> System.out.println("i like lambla 5");
        like5.like();



    }
}

interface ILike {
    void like();
}

//方式1 实现接口
class Like implements ILike {

    @Override
    public void like() {
        System.out.println("i like lambda 1");
    }
}
