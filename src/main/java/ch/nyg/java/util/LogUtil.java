package ch.nyg.java.util;

import java.util.logging.Level;
import java.util.logging.Logger;

public final class LogUtil {

    private static final Logger LOGGER = Logger.getLogger(LogUtil.class.getSimpleName());

    public static void info(Object o) {
        LOGGER.info(o.toString());
    }

    public static void info(String format, Object... args) {
        LOGGER.info(String.format(format, args));
    }

    public static void json(Object o) {
        LOGGER.info(JsonUtil.serialize(o));
    }

    public static void severe(Object o) {
        LOGGER.severe(o.toString());
    }

    public static void severe(String format, Object... args) {
        LOGGER.severe(String.format(format, args));
    }

    public static void severe(Throwable t) {
        LOGGER.log(Level.SEVERE, t.getMessage(), t);
    }

    public static void xml(Object o) {
        LOGGER.info(XmlUtil.serialize(o));
    }

    private LogUtil() {}
}
