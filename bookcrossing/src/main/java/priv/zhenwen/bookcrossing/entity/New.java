package priv.zhenwen.bookcrossing.entity;

import java.util.Date;
import java.io.Serializable;

/**
 * (New)实体类
 *
 * @author zhenwen
 * @since 2021-09-04 22:29:57
 */
public class New implements Serializable {
    private static final long serialVersionUID = -20349369088038089L;
    /**
     * 新闻ID
     */
    private Long newId;
    /**
     * 新闻标题
     */
    private String title;
    /**
     * 新闻内容
     */
    private String content;
    /**
     * 创建时间
     */
    private Date createDate;


    public Long getNewId() {
        return newId;
    }

    public void setNewId(Long newId) {
        this.newId = newId;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public Date getCreateDate() {
        return createDate;
    }

    public void setCreateDate(Date createDate) {
        this.createDate = createDate;
    }

}

