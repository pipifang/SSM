package com.qfedu.comment.test;


import com.qfedu.comment.constant.SystemCon;
import com.qfedu.comment.util.HttpUtils;

/**
 *@Author feri
 *@Date Created in 2018/11/29 12:03
 */
public class HttpTest {
    public static void main(String[] args) {
//        System.out.println(HttpUtils.getString(SystemCon.GET,
//                "http://t.weather.sojson.com/api/weather/city/101180101",null));
        System.out.println(HttpUtils.getString(SystemCon.GET,
                "http://www.baidu.com",null));
    }
}
