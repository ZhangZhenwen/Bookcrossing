package priv.zhenwen.bookcrossing.project.entity;

import java.util.Date;
import java.io.Serializable;

/**
 * (Comment)实体类
 *
 * @author zhenwen
 * @since 2021-09-10 18:59:00
 */
public class Comment implements Serializable {
    private static final long serialVersionUID = -42074067259069823L;
    /**
     * 留言ID
     */
    private Long commentId;
    /**
     * 上级留言ID
     */
    private Long parentId;
    /**
     * 留言内容
     */
    private String content;
    /**
     * 留言类型（1：公告留言、2：新闻留言、3：图书漂流问题、4：网站运维）
     */
    private String type;
    /**
     * 留言状态（0：根留言、1：子留言）
     */
    private String status;
    /**
     * 创建时间
     */
    private Date createDate;
    /**
     * 留言用户ID
     */
    private Long userId;


    public Long getCommentId() {
        return commentId;
    }

    public void setCommentId(Long commentId) {
        this.commentId = commentId;
    }

    public Long getParentId() {
        return parentId;
    }

    public void setParentId(Long parentId) {
        this.parentId = parentId;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public Date getCreateDate() {
        return createDate;
    }

    public void setCreateDate(Date createDate) {
        this.createDate = createDate;
    }

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

}

