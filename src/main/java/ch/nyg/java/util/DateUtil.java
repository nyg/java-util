package ch.nyg.java.util;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.ZoneId;
import java.util.Date;

public final class DateUtils {

    public static final String DATE_FORMAT = "dd.MM.yyyy";
    public static final String DATE_JSON_FORMAT = "yyyy-MM-dd";
    private static final SimpleDateFormat SIMPLE_DATE_FORMAT = new SimpleDateFormat(DATE_FORMAT);

    /**
     * Converts a String instance to a Date one if it has the following format:
     * dd.MM.yyyy. If it doesn't, a new Date instance is returned.
     */
    public static Date parse(String source) {
        try {
            return SIMPLE_DATE_FORMAT.parse(source);
        }
        catch (ParseException e) {
            return new Date();
        }
    }

    public static String format(Date date, String format) {
        return new SimpleDateFormat(format).format(date);
    }

    public static Date toDate(LocalDate localDate) {
        return Date.from(localDate.atStartOfDay(ZoneId.systemDefault()).toInstant());
    }

    private DateUtils() {}
}
