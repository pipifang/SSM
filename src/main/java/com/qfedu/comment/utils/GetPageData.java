package com.qfedu.comment.utils;


public class GetPageData {

    public static Integer getPageNum(String pageNum) {
        Integer pagenum;

        if (pageNum == null || pageNum.equals("")) {
            pagenum = 1;
        } else {
            pagenum = Integer.valueOf(pageNum);
        }

        return pagenum;
    }

    public static Integer getPageSize(String pageSize) {
        Integer pagesize = 0;

        if (pageSize == null || pageSize.equals("")) {
            pagesize = 10;
        } else {
            pagesize = Integer.valueOf(pageSize);
        }

        return pagesize;
    }
}
