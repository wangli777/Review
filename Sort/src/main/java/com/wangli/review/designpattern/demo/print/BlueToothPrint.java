package com.wangli.review.designpattern.demo.print;

import java.util.Map;

/**
 * @author WangLi
 * @date 2021/11/28 15:30
 * @description
 */
public class BlueToothPrint implements IMailPrint {

    @Override
    public boolean print(String orderId, Object mailInfo) {
        System.out.println("进行蓝牙打印");
        return true;
    }
}
