package data.util;

import java.util.Arrays;
import java.util.Locale;

public class ArrayListUtil {

    public static <T> boolean isIn(T t, T... tl) {
        return Arrays.asList(tl).contains(t);

    }

    public static <T> boolean containsIn(T t, T... tl) {
        if (t == null) {
            return false;
        }
        return Arrays.asList(tl).stream()
                .filter(s -> s != null
                        && t.toString().trim().toLowerCase(Locale.ENGLISH).contains(s.toString().trim().toLowerCase(Locale.ENGLISH)))
                .findAny().isPresent();

    }

    public static <T> boolean HasValue(T pObj1) {
        return pObj1 != null;
    }
}