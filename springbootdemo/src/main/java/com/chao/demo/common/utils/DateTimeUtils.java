package com.chao.demo.common.utils;

import java.time.Duration;
import java.time.Instant;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.Period;
import java.time.format.DateTimeFormatter;

/**
 * 时间工具类
 */
public class DateTimeUtils {

    public static final String DATE = "date";

    public static final String TIME = "time";

    public static final String DATETIME = "datetime";

    public static final String YEAR = "year";

    public static final String MONTH = "month";

    public static final String DAY = "day";

    public static final String HOUR = "hour";

    public static final String MINUTE = "minute";

    public static final String SECOND = "second";

    public static final String PATTERN_DATETIME = "yyyy-MM-dd HH:mm:ss";

    public static final String SUFFIX = "00:00:00";

    public static final String SUFFIX2 = "00:00:01";

    public static final String SUFFIX3 = ".000";

    public static final String SUFFIX4 = ".000Z";

    /**
     * 获取当前时间
     * @return 当前时间
     */
    public static String getNow() {
        return DateTimeUtils.getNow(DATETIME);
    }

    /**
     * 获取当前时间
     * @return 当前时间
     */
    public static String getNow(String type) {
        LocalDateTime now = LocalDateTime.now();
        switch (type) {
            case DATE:
                return now.format(DateTimeFormatter.ISO_LOCAL_DATE);
            case TIME:
                return now.format(DateTimeFormatter.ISO_LOCAL_TIME).substring(0, 8);
            default:
                return now.format(DateTimeFormatter.ISO_LOCAL_DATE) + " " + now.format(DateTimeFormatter.ISO_LOCAL_TIME).substring(0, 8);
        }
    }

    /**
     * 获取两日期的间隔时间，天数
     * @param date1 yyyy-MM-dd
     * @param date2 yyyy-MM-dd
     * return 间隔时间
     */
    public static long getPeriod(String date1, String date2) {
        return getPeriod(date1, date2, DAY);
    }

    /**
     * 获取两日期的间隔时间
     * @param date1 yyyy-MM-dd
     * @param date2 yyyy-MM-dd
     * @param type year/month/day
     * return 间隔时间
     */
    public static long getPeriod(String date1, String date2, String type) {
        LocalDate ld1 = LocalDate.parse(date1);
        LocalDate ld2 = LocalDate.parse(date2);
        Period period = Period.between(ld1, ld2);
        switch (type) {
            case YEAR:
                return period.getYears();
            case MONTH:
                return period.getMonths();
            default:
                return period.getDays();
        }
    }

    /**
     * 获取两日期的间隔时间，天数
     * @param datetime1 yyyy-MM-dd hh:mm:ss
     * @param datetime2 yyyy-MM-dd hh:mm:ss
     * return 间隔时间
     */
    public static long getDuration(String datetime1, String datetime2) {
        return getDuration(datetime1, datetime2, DAY);
    }

    /**
     * 获取两日期的间隔时间
     * @param datetime1 yyyy-MM-dd hh:mm:ss
     * @param datetime2 yyyy-MM-dd hh:mm:ss
     * @param type day/hour/minute/second
     * return 间隔时间
     */
    public static long getDuration(String datetime1, String datetime2, String type) {
        String dt1 = datetime1.substring(0, 10) + "T" + datetime1.substring(11) + SUFFIX4;
        String dt2 = datetime2.substring(0, 10) + "T" + datetime2.substring(11) + SUFFIX4;
        Duration duration = Duration.between(Instant.parse(dt1), Instant.parse(dt2));
        switch (type) {
            case DAY:
                return duration.toDays();
            case HOUR:
                return duration.toHours();
            case MINUTE:
                return duration.toMinutes();
            case SECOND:
                return duration.toMillis();
            default:
                return duration.toNanos();
        }
    }
}
