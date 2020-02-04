package com.wuhan.collecting.utils;

import java.text.SimpleDateFormat;

public class TimeUtil {
    /**
     * 日期格式字符串转换成时间戳
     *
     * @param dateStr 字符串日期
     * format   如：yyyy-MM-dd HH:mm:ss
     *
     * @return time
     */
    public static String Date2TimeStamp(String dateStr) {
        try {
            //String format = "yyyy-MM-dd HH:mm:ss";
            String format = "yyyy-mm-dd";
            SimpleDateFormat sdf = new SimpleDateFormat(format);
            return String.valueOf(sdf.parse(dateStr).getTime() / 1000);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return "";
    }
}
