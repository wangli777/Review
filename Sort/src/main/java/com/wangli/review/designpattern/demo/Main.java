package com.wangli.review.designpattern.demo;

import com.wangli.review.designpattern.demo.constant.PrintType;
import com.wangli.review.designpattern.demo.group.HTPrintMail;
import com.wangli.review.designpattern.demo.group.JtPrintMail;

import java.util.HashMap;

/**
 * @author WangLi
 * @date 2021/11/28 15:53
 * @description
 */
public class Main {
    public static void main(String[] args) {
        PrintMail printMail = new HTPrintMail();
        printMail.printMail(new HashMap<>(), "baishi", "12345464", PrintType.CLOUDPRINT);

        System.out.println("==========");
        PrintMail printMail1 = new JtPrintMail();
        printMail1.printMail(new HashMap<>(), "jitu", "78945643213", PrintType.CLOUDPRINT);
    }
}
