package priv.zhenwen.bookcrossing.framework.config;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

/**
 * @author zhenwen
 * @date 2021/9/5
 */
@Component
@ConfigurationProperties("application")
public class ApplicationProperties {
    /**
     * 项目名称
     */
    private String name;

    private String description;

    private String version;

    /**
     * 文件路径
     */
    private static String profile;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getVersion() {
        return version;
    }

    public void setVersion(String version) {
        this.version = version;
    }

    public static String getProfile() {
        return profile;
    }

    public void setProfile(String profile) {
        ApplicationProperties.profile = profile;
    }

    public static String getAvatarPath() {
        return getProfile() + "/avatar";
    }

    public static String getDownloadPath() {
        return getProfile() + "/download/";
    }

    public static String getUploadPath() {
        return getProfile() + "/upload";
    }
}
