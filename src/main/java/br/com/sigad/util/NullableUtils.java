package br.com.sigad.util;

public class NullableUtils {
    public static <T> T getNewValueIfNotNull(T pastValue, T newValue) {
        return newValue == null ? pastValue : newValue ;
    }

}
