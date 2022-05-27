package priv.zhenwen.bookcrossing.project.entity.vo;

import priv.zhenwen.bookcrossing.project.entity.Comment;

import java.util.Date;

/**
 * @author zhenwen
 * @date 2022/5/25
 */

public class CommentVO {
    /**
     * 留言ID
     */
    private Long commentId;
    /**
     * 图书名
     */
    private String name;
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
     * 留言用户
     */
    private String username;

    public CommentVO() {
    }

    public CommentVO(Comment comment, String name, String username) {
        this.commentId = comment.getCommentId();
        this.name = name;
        this.content = comment.getContent();
        this.type = comment.getType();
        this.status = comment.getStatus();
        this.createDate = comment.getCreateDate();
        this.username = username;
    }

    public Long getCommentId() {
        return commentId;
    }

    public void setCommentId(Long commentId) {
        this.commentId = commentId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
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

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }
}
