package priv.zhenwen.bookcrossing.common.util.file;

import org.apache.commons.lang3.time.DateFormatUtils;

import java.util.Date;

/**
 * @author zhenwen
 * @date 2020/11/20
 */

public class DateUtils extends org.apache.commons.lang3.time.DateUtils {

    /**
     * 日期路径 即年/月/日
     */
    public static final String datePath()
    {
        Date now = new Date();
        return DateFormatUtils.format(now, "yyyy/MM/dd");
    }
}
