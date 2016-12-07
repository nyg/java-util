package ch.nyg.java.util;

import com.thoughtworks.xstream.XStream;

public final class XmlUtils {

    private static final XStream XSTREAM = new XStream();

    public static String serialize(Object object) {
        return XSTREAM.toXML(object);
    }

    private XmlUtils() {}
}
