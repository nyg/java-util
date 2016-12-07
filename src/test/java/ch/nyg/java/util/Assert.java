package ch.nyg.java.util;

import java.util.Collection;
import java.util.Map;

public class Assert extends org.junit.Assert {

    public static void isGreaterThan(int value, int expectedValue, String message) {
        assertTrue(message, value > expectedValue);
    }

    public static void isBetween(double value, double min, double max, String message) {
        assertTrue(message, min <= value && value <= max);
    }

    public static void isEqual(Object value, Object expectedValue, String message) {
        assertTrue(message, value.equals(expectedValue));
    }

    public static void isNotEmpty(Collection<?> collection, String message) {
        assertNotNull(message, collection);
        assertTrue(message, !collection.isEmpty());
    }

    public static void hasSizeOf(Collection<?> collection, int expectedSize, String message) {
        assertNotNull(message, collection);
        assertTrue(message, collection.size() == expectedSize);
    }

    public static void hasSizeOf(Map<?, ?> map, int expectedSize, String message) {
        assertNotNull(message, map);
        assertTrue(message, map.size() == expectedSize);
    }

    public static void hasLengthOf(String[] array, int expectedLength, String message) {
        assertNotNull(message, array);
        isEqual(array.length, expectedLength, message);
    }

    public static void haveSameLength(String message, String[]... arrays) {
        for (int i = 1; i < arrays.length; i++) {
            assertNotNull(arrays[i - 1]);
            assertNotNull(arrays[i]);
            isEqual(arrays[i - 1].length, arrays[i].length, message);
        }
    }
}
