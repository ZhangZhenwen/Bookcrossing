package priv.zhenwen.bookcrossing.project.entity;

import java.io.Serializable;

/**
 * (Link)实体类
 *
 * @author zhenwen
 * @since 2021-09-05 10:46:19
 */
public class Link implements Serializable {
    private static final long serialVersionUID = -58409348048825766L;
    /**
     * 链接ID
     */
    private Long linkId;
    /**
     * 链接url
     */
    private String url;
    /**
     * 链接内容
     */
    private String content;


    public Long getLinkId() {
        return linkId;
    }

    public void setLinkId(Long linkId) {
        this.linkId = linkId;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

}

