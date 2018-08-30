/**
 *
 */
package com.maiya.shopcloud.base.utils;

import com.google.common.base.Strings;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

/**
 * 功能描述： 日期/时间工具类
 *
 * @author  mandy.hu
 */
public abstract class DateTimeUtils {
    private static final Logger logger = LoggerFactory.getLogger(DateTimeUtils.class);

    public static final long dateSecond = 24 * 60 * 60 * 1000;
    private static final String SHORT_PATTERN = "yyyyMMdd";
    private static final String LONG_PATTERN = "yyyyMMddHHmmss";
    private static final String DISPLAY_PATTERN = "yyyy-MM-dd HH:mm:ss";
    private static final String FIRST_DATE_PATTERN = "yyyy-MM-01";

    /**
     * 将日期转换为[yyyyMMddHHmmss]格式
     *
     * @param date
     * @return
     */
    public static String format(Date date) {
        return format(date, LONG_PATTERN);
    }

    /**
     * 将日期转换为指定格式
     *
     * @param date
     * @param pattern
     * @return
     */
    public static String format(Date date, String pattern) {
        if (Strings.isNullOrEmpty(pattern)) {
            pattern = LONG_PATTERN;
        }

        SimpleDateFormat s = new SimpleDateFormat(pattern);
        return s.format(date);
    }

    /**
     * 取得当前日期，格式为【yyyyMMdd】
     *
     * @return
     */
    public static String getCurrentDate() {
        return format(new Date(), SHORT_PATTERN);
    }

    /**
     * 按指定格式取得当前日期
     *
     * @param pattern
     * @return
     */
    public static String getCurrentDate(String pattern) {
        return format(new Date(), pattern);
    }

    /**
     * 取得当前时间，格式【yyyyMMddHHmmss】
     *
     * @return
     */
    public static String getNowString() {
        return format(new Date());
    }

    /**
     * 取得指定格式的当前时间
     *
     * @param pattern
     * @return
     */
    public static String getNowString(String pattern) {
        return format(new Date(), pattern);
    }

    /**
     * 将格式为【yyyy-MM-dd HH:mm:ss】的字符串转换为日期
     *
     * @param date
     * @return
     */
    public static Date parse(String date) {
        return parse(date, DISPLAY_PATTERN);
    }

    /**
     * 按指定格式，将字符串转换为日期
     *
     * @param date
     * @param pattern
     * @return
     */
    public static Date parse(String date, String pattern) {
        try {
            return new SimpleDateFormat(pattern).parse(date);
        } catch (ParseException e) {
            logger.error("解析字符串【" + date + "】为【" + pattern + "】格式的日期对象时发生异常：", e);
        }

        return null;
    }

    /**
     * 求两个日期的天数之差
     *
     * @param beginTime 开始时间
     * @param endTime   结束时间
     * @return
     */
    public static int getOddDateNum(String beginTime, String endTime) {
        Date dateBegin = parse(beginTime);

        if (dateBegin == null) {
            throw new IllegalArgumentException("无效的开始时间" + beginTime);
        }

        Date dateEnd = parse(endTime);

        if (dateEnd == null) {
            throw new IllegalArgumentException("无效的结束时间" + endTime);
        }

        int odd = (int) ((dateEnd.getTime() - dateBegin.getTime()) / (dateSecond));

        return odd;
    }

    /**
     * 取系统时间零点
     *
     * @return
     */
    public static Date getCurrentZeroTime() {
        Calendar calendar = Calendar.getInstance();

        calendar.set(Calendar.HOUR_OF_DAY, 0);
        calendar.set(Calendar.MINUTE, 0);
        calendar.set(Calendar.SECOND, 0);
        calendar.set(Calendar.MILLISECOND, 0);

        return calendar.getTime();
    }

    /**
     * 取当前月份第一天日期 (yyyy-MM-dd 00:00:00)
     *
     * @return Date
     */
    public static Date getCurrentMothFirstDay() {
        Calendar calendar = Calendar.getInstance();

        calendar.set(Calendar.DATE, 1);
        calendar.set(Calendar.HOUR_OF_DAY, 0);
        calendar.set(Calendar.MINUTE, 0);
        calendar.set(Calendar.SECOND, 0);
        calendar.set(Calendar.MILLISECOND, 0);

        return calendar.getTime();
    }


    /**
     * 取当前月份最后一天日期 (yyyy-MM-dd 23:59:59)
     *
     * @return Date
     */
    public static Date getCurrentMothLastDay() {
        Calendar calendar = Calendar.getInstance();

        calendar.setTime(getCurrentMothFirstDay());
        calendar.add(Calendar.MONTH, 1);
        calendar.add(Calendar.SECOND, -1);

        return calendar.getTime();
    }

    /**
     * 取当前月份第一天日期 (yyyy-MM-dd)
     *
     * @return String
     */
    public static String getCurrentMothFirstDayString() {
        return format(new Date(), FIRST_DATE_PATTERN);
    }

    public static void main(String[] args) {
        System.out.println(getCurrentMothLastDay());
    }
}
