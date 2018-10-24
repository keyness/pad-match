package com.boot.demo.utils;

import java.sql.Timestamp;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.GregorianCalendar;
import org.apache.commons.lang.time.FastDateFormat;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class DateUtil {
    private static final Logger log = LoggerFactory.getLogger(DateUtil.class);

    //
    public static final FastDateFormat FDFNOBLANK = FastDateFormat.getInstance("yyyyMMddHHmmss");

    public static String getCurrentTimeStr() {
        return FDFNOBLANK.format(System.currentTimeMillis());
    }

    public static String getCurrentTimeStr(String ft) {
        return new SimpleDateFormat(ft).format(System.currentTimeMillis());
    }

    public static Timestamp getCurrentTimestamp() {
        return new Timestamp(System.currentTimeMillis());
    }

    public static String parseTimestampToString(Timestamp timestamp, String ft) {
        try {
            SimpleDateFormat df = new SimpleDateFormat(ft);
            return df.format(timestamp);
        } catch (Exception e) {
            log.error(e.getMessage(), e);
            return null;
        }
    }

    public static Timestamp parseStringToTimestamp(String timestamp, String ft) {
        Timestamp result = null;
        try {
            if (StringHelper.isNotBlank(timestamp)) {
                SimpleDateFormat df = new SimpleDateFormat(ft);
                SimpleDateFormat dfResult = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
                Date date = df.parse(timestamp);
                result = Timestamp.valueOf(dfResult.format(date));
            }
        } catch (Exception e) {
            log.error(e.getMessage(), e);
        }
        return result;
    }

    public static Timestamp parseDateToTimestamp(Date date, String ft) {
        Timestamp timesamp = null;
        if (date != null) {
            try {
                SimpleDateFormat df = new SimpleDateFormat(ft);
                String result = df.format(date);
                timesamp = Timestamp.valueOf(result);
            } catch (Exception e) {
                log.debug(e.getMessage(), e);
            }
        }
        return timesamp;
    }

    public static String getTimeoutStr(int millisecond) {
        /*SimpleDateFormat format = new SimpleDateFormat("yyyyMMddHHmmss");
		Calendar cd = Calendar.getInstance();
		cd.setTime(new Date());
		cd.add(Calendar.MILLISECOND, millisecond);
		return format.format(cd.getTime());*/
        return FDFNOBLANK.format(System.currentTimeMillis() + millisecond);
    }

    public static String getCurrentDateStr() {
        return getDateStr(new Date());
    }

    public static String getDateStr(Date date) {
        SimpleDateFormat format = new SimpleDateFormat("yyyyMMdd");
        return format.format(date);
    }

    public static Date dateAdd(Date date, int field, int amount) {
        GregorianCalendar gc = new GregorianCalendar();
        gc.setTime(date);
        gc.add(field, amount);
        return gc.getTime();
    }

    public static String date2string(Date date, String pattern) {
        SimpleDateFormat sf = new SimpleDateFormat(pattern);
        return sf.format(date);
    }

    public static Date string2Date(String dateStr, String pattern) {
        SimpleDateFormat format = new SimpleDateFormat(pattern);
        try {
            return format.parse(dateStr);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return null;
    }

}
