package com.qfedu.comment.utils;
import com.github.pagehelper.PageHelper;
import com.qfedu.comment.constant.Constant;

/**
 * @program: BeautyNightBeautyWay
 * @description: 分页
 * @author: Administrator
 * @create: 2018-12-12 23:03
 **/

public class DivPageUtil {
    public static void divPage(Integer pageNum,Integer pageSize){
        int pagenum;
        int pagesize;
        if (pageNum==null){
            pagenum = Constant.PAGENUM;
        } else {
            pagenum = pageNum;
        }
        if (pageSize==null){
            pagesize = Constant.PAGESIZE;
        } else {
            pagesize = pageSize;
        }
        PageHelper.startPage(pagenum, pagesize);
    }
}

