package com.wangli.review.designpattern.demo.print;

/**
 * @author WangLi
 * @date 2021/11/28 15:27
 * @description 取号
 */
public interface IMailPrint {

    boolean print(String orderId, Object mailInfo);
}
