package priv.zhenwen.bookcrossing.project.entity;

import java.util.Date;
import java.io.Serializable;

/**
 * (Notice)实体类
 *
 * @author zhenwen
 * @since 2021-09-10 18:59:00
 */
public class Notice implements Serializable {
    private static final long serialVersionUID = 865431983703745459L;
    /**
     * 通知ID
     */
    private Long noticeId;
    /**
     * 通知标题
     */
    private String title;
    /**
     * 通知内容
     */
    private String content;
    /**
     * 创建时间
     */
    private Date createTime;
    /**
     * 通知用户ID（0：通知所有普通用户）
     */
    private Long userId;


    public Long getNoticeId() {
        return noticeId;
    }

    public void setNoticeId(Long noticeId) {
        this.noticeId = noticeId;
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

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

}

