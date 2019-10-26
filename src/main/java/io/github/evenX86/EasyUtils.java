package io.github.evenX86;

import org.apache.commons.lang3.StringUtils;

/**
 * Created with design-pattern-training
 *
 * @author xuyifei
 * @date 2019-10-25 6:17 PM
 */
public class EasyUtils {
    public static String toString(Object o) {
        return toString(o , "");
    }
    public static String toString(Object origin,String defaultValue) {
        if (origin == null) {
            return defaultValue;
        }
        String temp = origin.toString();
        if (StringUtils.isNotBlank(temp)){
            return temp;
        }
        return defaultValue;
    }

}
