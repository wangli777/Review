package com.wangli.review.designpattern.demo.group;

import com.wangli.review.designpattern.demo.PrintMail;

import java.util.HashMap;
import java.util.Map;

/**
 * @author WangLi
 * @date 2021/11/28 15:11
 * @description
 */
public class JtPrintMail extends PrintMail {
    @Override
    protected boolean verifyAccount(Object accountInfo) {
        System.out.println("验证极兔电子面单账号");
        return true;
    }

    @Override
    protected Map<String, String> fetchBillCode(Object accountInfo, Object receiverInfo) {
        System.out.println("极兔取号");
        Map map = new HashMap();
        map.put("mailNo", "JT77845412412");
        map.put("sortingCode", "D2-330-C8");
        map.put("pkgCode", "余杭区包");
        return map;
    }

}
