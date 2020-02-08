package com.wuhan.collecting.utils;

import java.text.SimpleDateFormat;
import java.util.Date;

public class TimeUtil {
    /**
     * 日期格式字符串转换成时间戳
     *
     * @param dateStr 字符串日期
     * format   如：yyyy-MM-dd HH:mm:ss
     *
     * @return time
     */
    public static long Date2TimeStamp(String dateStr) {
        try {
            //String format = "yyyy-MM-dd HH:mm:ss";
            String format = "yyyy-mm-dd";
            SimpleDateFormat sdf = new SimpleDateFormat(format);
            return sdf.parse(dateStr).getTime() / 1000;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return 0;
    }

    public static String TimeStamp2Date(long timeStamp) {
        String format = "yyyy-mm-dd";
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat(format);
        Date date = new Date(timeStamp * 1000);
        String res = simpleDateFormat.format(date);
        return res;
    }
}
