package com.wangli.review.designpattern.demo;

import com.wangli.review.designpattern.demo.constant.PrintType;
import com.wangli.review.designpattern.demo.print.BlueToothPrint;
import com.wangli.review.designpattern.demo.print.CloudPrint;
import com.wangli.review.designpattern.demo.print.IMailPrint;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/**
 * @author WangLi
 * @date 2021/11/28 14:53
 * @description 打印运单的模板抽象类
 */
public abstract class PrintMail {

    private static ConcurrentHashMap<PrintType, IMailPrint> printTypeMap = new ConcurrentHashMap<>();

    static {
        printTypeMap.put(PrintType.BLUETOOTH, new BlueToothPrint());
        printTypeMap.put(PrintType.CLOUDPRINT, new CloudPrint());
    }

    public void printMail(Map<String, String> accountInfo, Object receiverInfo, String orderId, PrintType printType) {
        //1.验证电子面单账号
        if (!verifyAccount(accountInfo)) {
            return;
        }
        //2.根据收件人信息取号、获取三段码、大头笔、集包编码等
        Object mailInfo = fetchBillCode(accountInfo, receiverInfo);

        //3.根据获取的单号、包裹路由信息进行订单打印
        IMailPrint mailPrint = printTypeMap.get(printType);
        if (mailPrint == null) {
            return;
        }
        mailPrint.print(orderId, mailInfo);
    }

    protected abstract boolean verifyAccount(Object accountInfo);

    protected abstract Object fetchBillCode(Object accountInfo, Object receiverInfo);

}
