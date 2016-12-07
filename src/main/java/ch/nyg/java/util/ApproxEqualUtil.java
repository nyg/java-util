package ch.nyg.java.util;

import java.time.Instant;
import java.time.temporal.ChronoUnit;
import java.util.Date;

public class ApproxEqualUtil {

    public static boolean areMoreOrLessEqual(Double a, Double b, Double maxDelta) {

        if (a == b) {
            return true;
        }

        // return false if one is null and the other is not
        if (a == null || b == null) {
            return false;
        }

        if (a == 0) {
            return b <= maxDelta;
        }

        if (b == 0) {
            return a <= maxDelta;
        }

        return Math.abs(a / b - 1) < maxDelta;
    }

    public static boolean areMoreOrLessEqual(double[] a, double[] b) {

        if (a == b) {
            return true;
        }

        if (a == null || b == null || a.length != b.length) {
            return false;
        }

        for (int i = 0; i < a.length; i++) {
            if (!areMoreOrLessEqual(a[i], b[i], 0.0001)) {
                return false;
            }
        }

        return true;
    }

    public static boolean areMoreOrLessEqual(Object[] a, Object[] b) {

        if (a == b) {
            return true;
        }

        if (a == null || b == null || a.length != b.length) {
            return false;
        }

        for (int i = 0; i < a.length; i++) {
            try {
                if (a[i] instanceof Double || a[i] instanceof Integer) {

                    Double valA = Double.valueOf(a[i].toString());
                    Double valB = Double.valueOf(b[i].toString());

                    if (!areMoreOrLessEqual(valA, valB, 0.0001)) {
                        return false;
                    }
                }
                else if (a[i] instanceof Date) {

                    Instant valA = ((Date) a[i]).toInstant().truncatedTo(ChronoUnit.DAYS);
                    Instant valB = ((Date) b[i]).toInstant().truncatedTo(ChronoUnit.DAYS);

                    if (!valA.equals(valB)) {
                        return false;
                    }
                }
            }
            catch (Exception e) {
                LogUtils.severe(e);
                return false;
            }
        }

        return true;
    }

    public static boolean areMoreOrLessEqual(Object[][] a, Object[][] b) {

        if (a == b) {
            return true;
        }

        if (a == null || b == null || a.length != b.length) {
            return false;
        }

        for (int i = 0; i < a.length; i++) {
            if (!areMoreOrLessEqual(a[i], b[i])) {
                return false;
            }
        }

        return true;
    }
}
