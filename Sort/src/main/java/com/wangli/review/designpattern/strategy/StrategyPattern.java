package com.wangli.review.designpattern.strategy;

import lombok.Data;

import java.util.Map;
import java.util.Objects;
import java.util.concurrent.ConcurrentHashMap;
import java.util.function.Consumer;

/**
 * @author WangLi
 * @date 2021/8/4 20:12
 * @description 策略模式
 * 为什么很多程序员不用switch，而是大量的if……else if？ - 古明地觉的回答 - 知乎
 * https://www.zhihu.com/question/475877331/answer/2035922184
 */
public class StrategyPattern {
    @Data
    static class Person{
        private String gender;
        private String name;
    }
    /**
     * 1、正常人写法
     */
    public static class NormalPerson{
        private static String MAN = "man";
        private static String WOMAN = "woman";

        public static void main(String[] args) {
            Person p = new Person();
            p.setGender(MAN);
            p.setName("张三");

            if(Objects.equals(p.getGender(),MAN)){
                System.out.println(p.getName() + "应该去男厕所");
            }

            if(Objects.equals(p.getGender(),WOMAN)){
                System.out.println(p.getName() + "应该去女厕所");
            }

        }
    }

    /**
     * Lambda策略模式写法
     */
    public static class LambdaPerson{
        private static String MAN = "man";
        private static String WOMAN = "woman";
        private static ConcurrentHashMap<String, Consumer<String>> FUNC_MAP = new ConcurrentHashMap<>();

        static {
            FUNC_MAP.put(MAN, name -> System.out.println(name + "应该去男厕所"));
            FUNC_MAP.put(WOMAN, name -> System.out.println(name + "应该去女厕所"));
        }

        public static void main(String[] args) {
            Person person = new Person();
            person.setGender(WOMAN);
            person.setName("小美");

            Person person1 = new Person();
            person1.setGender(MAN);
            person1.setName("张三");
            FUNC_MAP.get(person.gender).accept(person.getName());
            FUNC_MAP.get(person1.gender).accept(person1.getName());
        }

    }

    /**
     * DDD领域驱动设计思想+策略模式写法
     */
    public static class DDDPerson{
        private static String MAN = "man";
        private static String WOMAN = "woman";

        @Data
        static class Person{
            private String gender;
            private String name;

            private static Map<String, Consumer<String>> FUNC_MAP = new ConcurrentHashMap<>();
            static {
                FUNC_MAP.put(MAN,person ->{System.out.println(person + "应该去男厕所");});
                FUNC_MAP.put(WOMAN,person ->{System.out.println(person + "应该去女厕所");});
            }
            public void goToWC(){
                FUNC_MAP.get(gender).accept(name);
            }
        }

        static class PersonFactory{
            public static Person initPerson(String name ,String gender){
                Person p = new Person();
                p.setName(name);
                p.setGender(gender);
                return p;
            }
        }
        public static void main(String[] args) {
            Person p = PersonFactory.initPerson("张三",MAN);
            Person p2 = PersonFactory.initPerson("张三他老婆",WOMAN);

            p.goToWC();
            p2.goToWC();
        }

    }
}
