package com.wangli.review.designpattern.demo;

import com.wangli.review.designpattern.demo.print.IMailPrint;

import java.util.Map;

/**
 * @author WangLi
 * @date 2021/11/28 15:44
 * @description 打印策略控制
 */
public class PrintContext {

    private IMailPrint mailPrint;

    public PrintContext(IMailPrint mailPrint) {
        this.mailPrint = mailPrint;
    }

    public boolean print(String orderId, Object mailInfo) {
        return mailPrint.print(orderId, mailInfo);
    }
}
