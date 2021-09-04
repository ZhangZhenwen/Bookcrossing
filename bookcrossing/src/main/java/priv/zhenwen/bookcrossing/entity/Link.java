package priv.zhenwen.bookcrossing.entity;

import java.io.Serializable;

/**
 * (Link)实体类
 *
 * @author zhenwen
 * @since 2021-09-04 22:29:57
 */
public class Link implements Serializable {
    private static final long serialVersionUID = 646466121798997789L;
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

