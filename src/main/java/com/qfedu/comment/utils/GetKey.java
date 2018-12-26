package com.qfedu.comment.utils;


/**
 * @author gfc
 * 2018年12月03日 下午 3:23
 */
public class GetKey {
    public static void main(String[] args) {

        System.out.println(EncrypUtil.createAesKey());
        System.out.println(DateUtil.endOfDay().getTime());
        System.out.println(System.currentTimeMillis());

    }
}
