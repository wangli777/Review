package com.wangli.review.designpattern.demo.group;

import com.wangli.review.designpattern.demo.PrintMail;

import java.util.HashMap;
import java.util.Map;

/**
 * @author WangLi
 * @date 2021/11/28 15:11
 * @description
 */
public class HTPrintMail extends PrintMail {
    @Override
    protected boolean verifyAccount(Object accountInfo) {
        System.out.println("验证百世电子面单账号");
        return true;
    }

    @Override
    protected Map<String, String> fetchBillCode(Object accountInfo, Object receiverInfo) {
        System.out.println("百世取号");
        Map map = new HashMap();
        map.put("mailNo", "HT55004511021002");
        map.put("sortingCode", "D2-33d-C8");
        map.put("pkgCode", "文新街道包");
        return map;
    }

}
