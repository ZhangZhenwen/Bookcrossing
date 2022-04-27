package priv.zhenwen.bookcrossing.core.common.util;

import org.springframework.context.MessageSource;
import org.springframework.context.i18n.LocaleContextHolder;

/**
 * @author zhenwen
 * @date 2020/11/10
 */

public class MessageUtils {

    /**
     * 根据消息键和参数 获取消息
     *
     * @param code 消息键
     * @param args 参数
     * @return 翻译值
     */
    public static String message(String code, Object... args) {
        MessageSource messageSource = SpringUtils.getBean(MessageSource.class);
        return messageSource.getMessage(code, args, LocaleContextHolder.getLocale());
    }
}
