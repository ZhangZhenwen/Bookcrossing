package priv.zhenwen.bookcrossing.common.util;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

/**
 * @author zhenwen
 * @date 2020/11/20
 */
@Component
@ConfigurationProperties("application.upload")
public class ApplicationUtils {
    private String path;

    public String getPath() {
        return path;
    }

    public void setPath(String path) {
        this.path = path;
    }
}
