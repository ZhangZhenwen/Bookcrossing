package priv.zhenwen.bookcrossing.core.common.util;

import java.util.UUID;

/**
 * @author zhenwen
 * @date 2020/11/10
 */

public class IdUtils {

    private static final String CODE = "ABCDEFGHIJKLMNOPQRSTUVWXYZ1234567890";

    /**
     * 获取随机UUID
     *
     * @return UUID
     */
    public static String randomUUID() {
        return UUID.randomUUID().toString();
    }

    public static String randomCode(Integer len) {
        StringBuilder uuCode = new StringBuilder();

        for (int i = 0; i < len; i++) {
            uuCode.append(CODE.charAt((int) (Math.random() * 36)));
        }

        return uuCode.toString();
    }
}
