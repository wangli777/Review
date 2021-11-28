package com.wangli.review.designpattern.demo.print;

import java.util.Map;

/**
 * @author WangLi
 * @date 2021/11/28 15:30
 * @description
 */
public class CloudPrint implements IMailPrint {

    @Override
    public boolean print(String orderId, Object mailInfo) {
        System.out.println("进行物流来了云打印");
        return true;
    }
}
