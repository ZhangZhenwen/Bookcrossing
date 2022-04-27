package priv.zhenwen.bookcrossing.common.util;

/**
 * @author zhenwen
 * @date 2020/9/21
 */

public class StringUtils extends org.apache.commons.lang3.StringUtils {
    /**
     * * 判断一个对象是否为空
     *
     * @param object Object
     * @return true：为空 false：非空
     */
    public static boolean isNull(Object object)
    {
        return object == null;
    }

    /**
     * * 判断一个对象是否为空
     *
     * @param string string
     * @return true：为空 false：非空
     */
    public static boolean isEmpty(String string)
    {
        return string == null || string.isEmpty();
    }

    /**
     * * 判断一个对象是否非空
     *
     * @param object Object
     * @return true：非空 false：空
     */
    public static boolean isNotNull(Object object)
    {
        return !isNull(object);
    }

    /**
     * * 判断一个对象是否非空
     *
     * @param string string
     * @return true：非空 false：空
     */
    public static boolean isNotEmpty(String string)
    {
        return !isNull(string) && !string.isEmpty();
    }


}
