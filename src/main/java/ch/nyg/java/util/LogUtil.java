package ch.nyg.java.util;

import java.util.logging.Level;
import java.util.logging.Logger;

public final class LogUtils {

    private static final Logger LOGGER = Logger.getLogger(LogUtils.class.getSimpleName());

    public static void severe(Throwable t) {
        LOGGER.log(Level.SEVERE, t.getMessage(), t);
    }

    public static void severe(Object o) {
        LOGGER.severe(o.toString());
    }

    public static void info(Object o) {
        LOGGER.info(o.toString());
    }

    public static void info(String format, Object... args) {
        LOGGER.info(String.format(format, args));
    }

    public static void json(Object o) {
        LOGGER.info(JsonUtils.serialize(o));
    }

    public static void xml(Object o) {
        LOGGER.info(XmlUtils.serialize(o));
    }

    private LogUtils() {}
}
